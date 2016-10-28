package com.tangzq.autoconfig;

import com.tangzq.service.UserInfoService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;

/**
 * Bean配置
 */
@Configuration
public class AutoConfiguration {

    @Autowired
    private BeanFactory beanFactory;


    /**
     * 具体如何调用，参看本项目的test
     * @return
     */
    @Bean(name =UserInfoService.HTTP_INVOKER_EXPORT_CONTEXT)
    public HttpInvokerServiceExporter userInfoServiceExporter() {
        HttpInvokerServiceExporter exporter = new HttpInvokerServiceExporter();
        exporter.setServiceInterface(UserInfoService.class);
        exporter.setService(beanFactory.getBean(UserInfoService.class));
        return exporter;
    }
}
