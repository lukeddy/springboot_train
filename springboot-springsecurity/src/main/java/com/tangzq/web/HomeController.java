package com.tangzq.web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/res")
public class HomeController {

    @RequestMapping(value ="/public/resource/{resId}")
    public String publicResource(@PathVariable int resId){
        return "访问公共资源，id是："+resId;
    }

    @RequestMapping(value ="/private/resource/{resId}")
    public String privateResource(@PathVariable int resId){
        return "访问私有资源,ID为："+resId;
    }

    @RequestMapping(value ="/private/admin/resource/{resId}")
    public String privateAdminResource(@PathVariable int resId){
        return "只有管理员可以访问的私有资源,ID为："+resId;
    }
}
