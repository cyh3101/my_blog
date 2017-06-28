package com.cyh.blog.controller;

import com.cyh.blog.entity.User;
import com.cyh.blog.service.impl.UserService;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.List;

/**
 * Created by cai on 2017/6/25.
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private SessionDAO sessionDAO;

    @RequestMapping(value = "/home")
    public String admin(){
        return "/admin/home";
    }

    //查看注册用户
    @RequiresRoles(value = {"blogger","administrator"} , logical = Logical.OR)
    @RequestMapping(value = "/checkUserList")
    public String checkUserList(Model model){
        List<User> users = userService.getUserList();
        model.addAttribute("users" , users);
        return "admin/userList";
    }

    @RequiresRoles(value = {"blogger" , "administrator"} , logical = Logical.OR)
    @RequestMapping(value = "checkSessionList")
    public String checkSessionList(Model model){
        Collection<Session> sessions = sessionDAO.getActiveSessions();
        model.addAttribute("sessions" , sessions);
        System.out.println(sessions.size());
        return null;
    }

}
