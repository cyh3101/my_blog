package com.cyh.blog.controller;

import com.cyh.blog.entity.Blog;
import com.cyh.blog.service.impl.BlogService;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by cai on 2017/6/25.
 */
@Controller
@RequestMapping(value = "/blog")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @RequiresRoles(value = {"blogger" , "administrator"} , logical = Logical.OR)
    @RequestMapping(value = "/write")
    public String addBlogView(){
        return "blog/write";
    }

    @RequiresRoles(value = {"blogger" , "administrator"} , logical = Logical.OR)
    @RequestMapping(value = "/submit")
    public String writeBlog(Model model , Blog blog){
        blogService.insertBlog(blog);
        return  "redirect:/";
    }
}
