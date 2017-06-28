package com.cyh.blog.controller;

import com.cyh.blog.entity.Blog;
import com.cyh.blog.mapper.BlogMapper;
import com.cyh.blog.service.impl.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by cai on 2017/6/18.
 */
@Controller
public class HomeController {
    @Autowired
    private BlogService blogService;

    @RequestMapping(value = "/home")
    public String home(Model model){
        List<Blog> blogs = blogService.getAllBlog();
        model.addAttribute("blogs" , blogs);
        return "home";
    }

    @ResponseBody
    @RequestMapping(value = "/getblog")
    public List<Blog> getBlog(Blog blog){
        List<Blog> blogs = blogService.getAllBlog();
        return  blogs;
    }
}
