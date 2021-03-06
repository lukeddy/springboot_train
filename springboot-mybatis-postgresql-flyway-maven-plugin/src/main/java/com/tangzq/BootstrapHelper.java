package com.tangzq;

import com.tangzq.config.GlobalConfig;
import org.flywaydb.core.Flyway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ResourceBundle;

/**
 * 项目启动时做一些初始化工作，如数据初始化
 */
@Component
@EnableConfigurationProperties(GlobalConfig.class)
public class BootstrapHelper implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger logger = LoggerFactory.getLogger(BootstrapHelper.class);

    @Autowired
    private GlobalConfig globalConfig;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
      logger.info("项目开始启动....");
      logger.info("项目启动初始化工作开始..");
      logger.info("环境："+globalConfig.getEnv());
      logger.info("测试配置1："+globalConfig.getTestURL());
      logger.info("测试配置2："+globalConfig.getEnv());
      //在这里初始化数据库
      initDatabase();
      logger.info("项目启动初始化工作完成！Great!");
    }

    /**
     * 使用Flyway初始换数据库
     */
    private void initDatabase(){
        ResourceBundle applicationProperties = ResourceBundle.getBundle("application");
        Flyway flyway = new Flyway();
        flyway.setDataSource(
                applicationProperties.getString("spring.datasource.url"),
                applicationProperties.getString("spring.datasource.username"),
                applicationProperties.getString("spring.datasource.password"));
        flyway.setBaselineOnMigrate(true);
        flyway.migrate();
        logger.info("初始换数据库完成！");
    }
}
