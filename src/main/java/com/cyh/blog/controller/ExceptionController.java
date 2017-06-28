package com.cyh.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by cai on 2017/6/28.
 */
@Controller
public class ExceptionController {
    @RequestMapping(value = "/unauthorized")
    public String unauthorized(){
        return "/unauthorized";
    }

    @RequestMapping(value = "/error/error")
    public String error(){
        return "/error/error";
    }
}
