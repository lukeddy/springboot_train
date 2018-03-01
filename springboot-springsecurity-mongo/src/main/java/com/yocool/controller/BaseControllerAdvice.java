package com.yocool.controller;

import com.yocool.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class BaseControllerAdvice {

    @Value("${info.app.version}")
    private String applicationVersion;

    @ModelAttribute("currentUser")
    public User getCurrentUser(Authentication authentication) {
        return (authentication == null) ? null : (User) authentication.getPrincipal();
    }

    @ModelAttribute("applicationVersion")
    public String getApplicationVersion() {
        return applicationVersion;
    }

}
