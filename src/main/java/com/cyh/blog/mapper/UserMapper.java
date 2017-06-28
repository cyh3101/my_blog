package com.cyh.blog.mapper;

import com.cyh.blog.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;
import java.util.Set;

@MapperScan
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(@Param("id") Integer id);

    User selectByUserName(@Param("userName") String userName);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    Set<String> getRolesByUserName(String userName);

    Set<String> getPermissionsByRole(String roleName);

    List<User> getUserList();
}