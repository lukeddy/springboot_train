package com.tangzq.mapper;

import com.tangzq.model.User;

import java.util.List;


public interface UserMapper {
    List<User> findUserInfo();
    User findUserById(int id);
    int insertUser(User user);
}
