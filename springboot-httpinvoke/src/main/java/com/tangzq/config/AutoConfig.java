package com.tangzq.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 自动装载配置信息
 * Author tangzq.
 */
@Configuration
@ConfigurationProperties(prefix = "com.tangzq.server.config")
public class AutoConfig {

    //自动装载application-*.properties中的配置信息
    private String appName;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }
}
