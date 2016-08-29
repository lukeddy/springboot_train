package com.yocool.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * WEB控制器
 */
@Controller
public class HomeController {

    /**
     * 网站首页
     * @return
     */
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String listData(){
        return "index";
    }

    /**
     * 网站首页
     * @return
     */
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    @ResponseBody
    public String hello(String name){
        return "Hello "+name;
    }

}
