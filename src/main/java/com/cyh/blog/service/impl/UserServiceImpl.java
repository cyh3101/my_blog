package com.cyh.blog.service.impl;

import com.cyh.blog.entity.User;
import com.cyh.blog.entity.UserRole;
import com.cyh.blog.mapper.UserMapper;
import com.cyh.blog.mapper.UserRoleMapper;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by cyh3101 on 2017/6/17.
 */
@Service("userService")
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    //通过id获取用户
    public User getUserById(Integer id) {
        return this.userMapper.selectByPrimaryKey(id);
    }

    //通过用户名获取用户
    public User getByUserName(String userName) {
        return this.userMapper.selectByUserName(userName);
    }

    public Set<String> getRolesByUserName(String userName) {
        return this.userMapper.getRolesByUserName(userName);
    }

    //通过用户名获取权限
    public Set<String> getPermissionsByUserName(String userName){
        Set<String> permissions = new HashSet<String>();
        Set<String> roles = this.getRolesByUserName(userName);
        for (String role:roles
             ) {
            for (String permission:this.getPermissionsByRole(role)
                 ) {
                permissions.add(permission);
            }
        }
        return  permissions;
    }

    //通过角色获取用户权限
    public Set<String> getPermissionsByRole(String roleName) {
        return this.userMapper.getPermissionsByRole(roleName);
    }

    public void insertUser(User user) {
        String algorithmName = "md5";
        String userName = user.getUsername();
        String password = user.getPassword();
        String salt1 = userName;
        String salt2 = new SecureRandomNumberGenerator().nextBytes().toHex();
        int hashIterations = 3;
        SimpleHash hash = new SimpleHash(algorithmName,password,salt1 + salt2 , hashIterations);
        String encodeedPassword = hash.toHex();
        user.setPassword(encodeedPassword);
        user.setSalt(salt2);
        user.setCreatetime(new Date());
        this.userMapper.insertSelective(user);
    }

    public void giveRole(User user, Integer roleId) {
        UserRole userRole = new UserRole();
        userRole.setUserid(userMapper.selectByUserName(user.getUsername()).getId());
        userRole.setRoleid(roleId);
        this.userRoleMapper.insert(userRole);
    }

    public void updateLoginLastTime(User user, Session session) {
        user.setLasttime(session.getStartTimestamp());
        this.userMapper.updateByPrimaryKey(user);
    }

    public void updateUser(User user, Integer id) {
        user.setId(id);
        System.out.println(user.toString());
        this.userMapper.updateByPrimaryKeySelective(user);
    }

    public List<User> getUserList() {
        return this.userMapper.getUserList();
    }
}
