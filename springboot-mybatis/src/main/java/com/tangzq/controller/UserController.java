package com.tangzq.controller;

import com.tangzq.model.User;
import com.tangzq.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class UserController {

    private Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("/getAllUser")
    @ResponseBody
    public List<User> getAllUser() {
        return userService.getUserList();
    }

    @RequestMapping("/getUser")
    @ResponseBody
    public User getUser(int id) {
        return userService.getUser(id);
    }
}
