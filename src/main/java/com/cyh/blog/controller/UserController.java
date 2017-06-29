package com.cyh.blog.controller;

import com.cyh.blog.entity.User;
import com.cyh.blog.service.impl.UserService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * Created by cai on 2017/6/20.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login" , method = RequestMethod.GET)
    public String loginView(){
        return  "/user/login";
    }

    @RequestMapping(value = "/login" , method = RequestMethod.POST)
    public String login(User user , Model model){
        Subject subject = SecurityUtils.getSubject();

        if(!subject.isAuthenticated()){
            UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername() , user.getPassword());
            token.setRememberMe(true);
            try{
                subject.login(token);
                Session session = subject.getSession();
                userService.updateLoginLastTime(userService.getByUserName(user.getUsername()),session);
                return "redirect:/";
            } catch (UnknownAccountException e){
                model.addAttribute("errorMsg" , "UnknownAccountException");
            } catch (IncorrectCredentialsException e){
                model.addAttribute("errorMsg" , "IncorrectCredentialsException");
            }catch (LockedAccountException e){
                model.addAttribute("errorMsg" ,"LockedAccountException");
            }
            return "user/login";
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/logout" , method = RequestMethod.GET)
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        if(subject.isAuthenticated()){
            System.out.println(session.getLastAccessTime());
            subject.logout();
        }else if(subject.isRemembered()){
            subject.logout();
        }
        return "redirect:/home";
    }

    @RequestMapping(value = "/register" , method = RequestMethod.GET)
    public String registerView(){
        return "user/register";
    }

    //注册账号
    @RequestMapping(value = "/register" , method = RequestMethod.POST)
    public String register(Model model , @Valid User user , BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            System.out.println(allErrors.size());
            for (ObjectError error:allErrors
                 ) {
                System.out.println(error.getDefaultMessage());
            }
            model.addAttribute("errors" , allErrors);
            model.addAttribute("user" , user);
            return "/user/register";
        }
        if(userService.getByUserName(user.getUsername()) == null){
            userService.insertUser(user);
            userService.giveRole(user , 3);//赋予普通用户角色
            return "redirect:/";
        }else {
            model.addAttribute("errors" , "user has been registered.");
            model.addAttribute("user" , user);
            return "user/register";
        }
    }

    @RequestMapping(value = "/setting/{user_name}")
    public String setting(@PathVariable(value = "user_name") String userName , Model model){
        if(userName != null && userName.equals(SecurityUtils.getSubject().getPrincipal())){
            User user = userService.getByUserName(userName);
            model.addAttribute("user" , user);
            return "/user/setting";
        } else {
            return "redirect:/user/setting/" + SecurityUtils.getSubject().getPrincipal();
        }
    }

    @RequestMapping(value = "/update")
    public String update(Integer id , User user){
        userService.updateUser(user , id);
        return "redirect:/";
    }

    @RequestMapping(value = "/password" , method = RequestMethod.GET)
    public String passwordView(Model model){
        model.addAttribute("user" ,userService.getByUserName(SecurityUtils.getSubject().getPrincipal().toString()));
        return "/user/password";
    }

    @RequestMapping(value = "password" , method = RequestMethod.POST)
    public String password(Model model , HttpServletRequest request , HttpServletResponse response){
        String oldPassword = request.getParameter("oldpassword");
        String password = request.getParameter("password");
        String passwordrepeat = request.getParameter("passwordrepeat");

        if(!SecurityUtils.getSubject().isAuthenticated()){
            return "redirect:/";
        }
        User user = userService.getByUserName(SecurityUtils.getSubject().getPrincipal().toString());

        String algorithmName = "MD5";
        String userName = user.getUsername();
        int hashIterations = 3;
        SimpleHash hash = new SimpleHash(algorithmName , oldPassword ,userName + user.getSalt(),hashIterations);
        if(!user.getPassword().equals(hash.toHex())){
            model.addAttribute("errorMsg" , "原密码不对");
            return "/user/password";
        }
        if(!password.equals(passwordrepeat)){
            model.addAttribute("errorMsg" , "两次密码必须相同");
            return "/user/password";
        }
        if(password == null || password.equals("")){
            model.addAttribute("errorMsg" , "密码不能为空");
            return "/user/password";
        }

        user.setPassword((new SimpleHash(algorithmName , password , userName + user.getSalt() , hashIterations)).toHex());
        userService.updateUser(user , user.getId());

        return  "/home";
    }

}
