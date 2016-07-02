package com.yocool.controller.web;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;

/**
 * 错误处理控制器
 * Author tangzq.
 */
@Controller
public class AppErrorController implements ErrorController {

    //TODO 错误处理
    @Override
    public String getErrorPath() {
        return "/error";
    }
}
