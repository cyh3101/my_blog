package com.cyh.blog.service.impl;

import com.cyh.blog.entity.Blog;
import com.cyh.blog.mapper.BlogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by cyh3101 on 2017/6/18.
 */
@Service
public class BlogServiceImpl implements BlogService{

    @Autowired
    private BlogMapper blogMapper;

    public void deleteById(Integer id) {
        this.blogMapper.deleteByPrimaryKey(id);
    }

    public void insertBlog(Blog blog) {
        blog.setCreatetime(new Date());
        blog.setAltertime(new Date());
        this.blogMapper.insert(blog);
    }

    public Blog getBlogById(Integer id) {
        return this.blogMapper.selectByPrimaryKey(id);
    }

    public Blog getBlogByTitle(String title) {
        return this.blogMapper.selectByTitle(title);
    }

    public int updateAlertTime(Integer id, Blog blog) {
        return 0;
    }

    public List<Blog> getAllBlog() {
        List<Blog> blogs = blogMapper.getBlogList();
        return blogs;
    }
}
