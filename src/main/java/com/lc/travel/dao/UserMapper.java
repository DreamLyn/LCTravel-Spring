package com.lc.travel.dao;

import java.util.ArrayList;

import com.lc.travel.entity.User;

public interface UserMapper {
    int deleteByPrimaryKey(String name);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String name);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    ArrayList<User> getUsers();
}