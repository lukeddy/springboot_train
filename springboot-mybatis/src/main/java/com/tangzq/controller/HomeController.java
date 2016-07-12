package com.tangzq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    /**
     * 首页
     * @return
     */
    @RequestMapping("/")
    public String index() {
        return "index";
    }
    
}
