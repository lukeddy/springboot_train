package com.tangzq.config;

import com.tangzq.service.MyService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;

/**
 * Author tangzq.
 */
@Configuration
@EnableConfigurationProperties(AutoConfig.class)
public class BeanConfig {

    @Autowired
    private BeanFactory beanFactory;

    /**
     * 提供远程调用bean,調用地址為：http://host:port/httpInvoke/MyService
     * @return
     */
    @Bean(name ="/httpInvoke/MyService")
    public HttpInvokerServiceExporter beanMyService() {
        HttpInvokerServiceExporter exporter = new HttpInvokerServiceExporter();
        exporter.setServiceInterface(MyService.class);
        exporter.setService(beanFactory.getBean(MyService.class));
        return exporter;
    }
}
