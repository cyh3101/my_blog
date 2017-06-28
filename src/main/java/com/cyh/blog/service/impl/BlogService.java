package com.cyh.blog.service.impl;

import com.cyh.blog.entity.Blog;

import java.util.List;

/**
 * Created by cyh3101 on 2017/6/18.
 */
public interface BlogService {
    void deleteById(Integer id);

    void insertBlog(Blog blog);

    Blog getBlogById(Integer id);

    Blog getBlogByTitle(String title);

    int updateAlertTime(Integer id , Blog blog);

    List<Blog> getAllBlog();

}
