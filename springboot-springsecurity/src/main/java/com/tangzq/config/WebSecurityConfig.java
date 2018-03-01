package com.tangzq.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //设置内存账户并赋予角色
        auth.inMemoryAuthentication()
                .withUser("test").password("123456").roles("USER")
                .and()
                .withUser("tangzq").password("123456").roles("USER","ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //设置角色可访问资源
        http.authorizeRequests()
                .antMatchers("/res/private/resource/**").hasRole("USER")
                .antMatchers("/res/private/admin/**").hasRole("ADMIN")
                .and()
                .formLogin();
    }


}
