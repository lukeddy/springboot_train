package com.yocool.rpc.server.service;

import com.yocool.rpc.api.entity.User;
import com.yocool.rpc.api.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    List<User> lists = new ArrayList<User>();

    @Override
    public String test(String input) {
        return input + new Date();
    }

    @Override
    public List<User> listUsers() {
        return lists;
    }

    @Override
    public User createUser(String name, int age) {
        User user = new User();
        user.setId(lists.size());
        user.setName(name);
        user.setAge(age);
        lists.add(user);
        return user;
    }
}
