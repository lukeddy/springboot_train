package com.tangzq.web;

import com.tangzq.exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 异常测试控制器
 */
@Controller
public class TestController {

    @RequestMapping("/test")
    public String hello() throws Exception {
        throw new Exception("发生错误");
    }

    @RequestMapping("/testJSON")
    public String json() throws MyException {
        throw new MyException("发生错误2");
    }

    @RequestMapping("/")
    public String index(ModelMap map) {
        map.addAttribute("title", "异常测试");
        return "index";
    }

}