package com.yocool;

import com.yocool.config.MyProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * 项目启动时做一些初始化工作
 */
@Component
@EnableConfigurationProperties(MyProperties.class)
public class BootstrapHelper implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger logger = LoggerFactory.getLogger(BootstrapHelper.class);

    @Autowired
    private MyProperties myProperties;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
      logger.info("项目开始启动....");
      logger.info("项目启动初始化工作开始..");
        System.out.println(myProperties.getEnv());
        System.out.println(myProperties.getTestURL());
        System.out.println(myProperties.getDefaultProperties());
        System.out.println(myProperties.getMyConfig1());
        System.out.println(myProperties.getMyConfig2());
        System.out.println(myProperties.getMyMap());

        System.out.println("===万能的分割线===");
        System.out.println(myProperties.getPersonList());

      logger.info("项目启动初始化工作完成！Great!");




    }
}
