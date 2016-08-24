package com.yocool.rpc.client.config;

import com.yocool.rpc.api.service.HelloService;
import com.yocool.rpc.api.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;


@Configuration
public class ClientConfig {

    @Bean
    public UserService userService() {
        HttpInvokerProxyFactoryBean fb = new HttpInvokerProxyFactoryBean();
        fb.setServiceUrl("http://localhost:8080"+UserService.HTTP_RPC_URI);
        fb.setServiceInterface(UserService.class);
        fb.afterPropertiesSet();
        return (UserService)fb.getObject();
    }

    @Bean
    public HelloService demoService() {
        HttpInvokerProxyFactoryBean fb = new HttpInvokerProxyFactoryBean();
        fb.setServiceUrl("http://localhost:8080/"+HelloService.HTTP_RPC_URI);
        fb.setServiceInterface(HelloService.class);
        fb.afterPropertiesSet();
        return (HelloService)fb.getObject();
    }
}
