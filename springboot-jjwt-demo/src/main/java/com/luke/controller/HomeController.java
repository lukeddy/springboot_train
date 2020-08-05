package com.luke.controller;

import com.luke.config.JwtProperties;
import com.luke.entity.UserInfo;
import com.luke.utils.JwtUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class HomeController {

    @Autowired
    private JwtProperties jwtProperties;

    @RequestMapping("")
    public String home(){
        return "Hello world";
    }

    @RequestMapping("/login")
    public String login(UserInfo userInfo){
        //生成token
        try {
          return  JwtUtils.generateToken(userInfo,jwtProperties.getPrivateKey(), jwtProperties.getExpire());
        } catch (Exception e) {
           log.error(e);
            return "出错啦";
        }
    }

    @RequestMapping("/parse")
    public UserInfo getUserInfoFromToken(String token){
        //生成token
        try {
            return  JwtUtils.getInfoFromToken(token,jwtProperties.getPublicKey());
        } catch (Exception e) {
            log.error(e);
            return null;
        }
    }
}
