package com.yocool.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * API控制器
 */
@RestController
@RequestMapping("/api")
public class HomeController {

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Map<String,Object> listData(){
        Map<String,Object> data=new HashMap<>();
        data.put("firstName","Jack");
        data.put("lastName","Bluce");
        data.put("age",20);
        return data;
    }

}
