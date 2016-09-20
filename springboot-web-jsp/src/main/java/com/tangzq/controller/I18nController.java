package com.tangzq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;

@Controller
public class I18nController {

    @Autowired
    private MessageSource messageSource;

    /**
     * i18n测试页面
     * @return
     */
    @RequestMapping("/i18n")
    public String i18n() {
        return "i18n/test";
    }

    /**
     *
     * 通过在请求头中添加如： Accept-Language:en-Us 更改语言
     * @return
     */
    @RequestMapping("/change")
    public String msg(String lang){
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage ("api.success.message", null, locale );
    }

}