package com.tangzq;

import com.tangzq.config.GlobalConfig;
import org.flywaydb.core.Flyway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.flyway.FlywayProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.thymeleaf.util.StringUtils;

/**
 * 项目启动时做一些初始化工作，如数据初始化
 */
@Component
@EnableConfigurationProperties(value = {GlobalConfig.class, FlywayProperties.class})
public class BootstrapHelper implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger logger = LoggerFactory.getLogger(BootstrapHelper.class);

    @Autowired
    private GlobalConfig globalConfig;

    @Autowired
    private FlywayProperties flywayProperties;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
      logger.info("项目开始启动....");
      logger.info("项目启动初始化工作开始..");
      logger.info("环境："+globalConfig.getEnv());
      logger.info("测试配置1："+globalConfig.getTestURL());
      logger.info("测试配置2："+globalConfig.getEnv());
      initDatabase();
      logger.info("项目启动初始化工作完成！Great!");
    }

    /**
     * 使用Flyway初始换数据库
     */
    private void initDatabase(){
        Flyway flyway = new Flyway();
        flyway.setLocations(StringUtils.join(flywayProperties.getLocations(),","));
        flyway.setDataSource(
                flywayProperties.getUrl(),
                flywayProperties.getUser(),
                flywayProperties.getPassword());
        flyway.setBaselineOnMigrate(true);
        logger.warn("开始清除数据表信息");
        flyway.clean();
        logger.warn("清除完成！");
        logger.info("重新创建数据表信息");
        flyway.migrate();
        logger.info("初始换数据库表和数据完成！");
    }
}
