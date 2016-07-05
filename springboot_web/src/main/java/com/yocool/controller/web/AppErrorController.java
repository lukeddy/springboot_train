package com.yocool.controller.web;

import org.slf4j.Logger;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 错误处理控制器
 * Author tangzq.
 */
@Controller
public class AppErrorController implements ErrorController {

    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(AppErrorController.class);

    private static final String ERROR_PATH = "/error";

    @RequestMapping(value=ERROR_PATH)
    public String handleError(){
        return "error/404";
    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }


}
