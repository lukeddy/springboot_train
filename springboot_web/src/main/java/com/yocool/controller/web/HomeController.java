package com.yocool.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

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

}
