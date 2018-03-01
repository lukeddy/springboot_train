package com.yocool.controller;

import com.yocool.model.User;
import com.yocool.service.impl.MyUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

/**
 * Author tangzq.
 */
@Controller
@Slf4j
public class HomeController {

    @Autowired
    private MyUserService userService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String home(){
        return "index";
    }

    @RequestMapping(value = "/loginPage",method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

    @RequestMapping(value = "/doLogin",method = RequestMethod.POST)
    public ModelAndView doLogin(User user) {
        User loginUser=userService.loadUserByUsername(user.getUsername());
        //TODO
        log.info(user.toString());
        return new ModelAndView("redirect:/book/list");
    }


    @RequestMapping(value = "/dashboard",method = RequestMethod.GET)
    public String dashboard(){
        return "home";
    }

}
