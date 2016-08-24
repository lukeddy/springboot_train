package com.yocool.rpc.server.config;

import com.yocool.rpc.api.service.HelloService;
import com.yocool.rpc.api.service.UserService;
import com.yocool.rpc.server.service.DemoServiceImpl;
import com.yocool.rpc.server.service.UserServiceImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;


@Configuration
public class AutoConfig {

    @Autowired
    private BeanFactory beanFactory;

    /**
     * 提供远程调用bean,调用地址如：http://host:port/httpInvoke/HelloService
     * @return
     */
    @Bean(name =HelloService.HTTP_RPC_URI)
    public HttpInvokerServiceExporter demoService() {
        HttpInvokerServiceExporter exporter = new HttpInvokerServiceExporter();
        exporter.setServiceInterface(HelloService.class);
        exporter.setService(beanFactory.getBean(DemoServiceImpl.class));
        return exporter;
    }

    /**
     * 提供远程调用bean,调用地址如：http://host:port/httpInvoke/UserService
     * @return
     */
    @Bean(name =UserService.HTTP_RPC_URI)
    public HttpInvokerServiceExporter helloService() {
        HttpInvokerServiceExporter exporter = new HttpInvokerServiceExporter();
        exporter.setServiceInterface(UserService.class);
        exporter.setService(beanFactory.getBean(UserServiceImpl.class));
        return exporter;
    }
}
