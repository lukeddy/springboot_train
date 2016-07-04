package com.yocool.controller.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * REST API接口
 * Author tangzq.
 */
@ResponseBody
@RestController
@RequestMapping("/api")
public class MyAPIController {

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Map<String,Object> listData(){
        Map<String,Object> data=new HashMap<>();
        data.put("firstName","Jack");
        data.put("lastName","Bluce");
        data.put("age",20);
        return data;
    }



}
