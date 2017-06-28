package com.cyh.blog.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by cai on 2017/6/26.
 */
public class CustomExceptionResolver implements HandlerExceptionResolver{
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        if(e instanceof IOException){
            modelAndView.addObject("message" , "IOException");
            modelAndView.setViewName("error/error");
        } else if(e instanceof SQLException){
            modelAndView.addObject("message" , "SQLException");
            modelAndView.setViewName("error/error");
        } else {
            modelAndView.addObject("message" , e.getMessage());
            modelAndView.setViewName("error/error");
        }
        modelAndView.setViewName("/error/error");
        return modelAndView;
    }
}
