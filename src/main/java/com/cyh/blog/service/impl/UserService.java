package com.cyh.blog.service.impl;

import com.cyh.blog.entity.User;
import com.cyh.blog.mapper.UserMapper;
import org.apache.shiro.session.Session;

import java.util.List;
import java.util.Set;

/**
 * Created by cyh3101 on 2017/6/17.
 */
public interface UserService {
    User getUserById(Integer id);

    User getByUserName(String userName);

    Set<String> getRolesByUserName(String userName);

    Set<String> getPermissionsByUserName(String userName);

    Set<String> getPermissionsByRole(String roleName);

    void insertUser(User user);

    void giveRole(User user , Integer roleId);

    void updateLoginLastTime(User user , Session session);

    void updateUser(User user , Integer id);

    List<User> getUserList();
}

