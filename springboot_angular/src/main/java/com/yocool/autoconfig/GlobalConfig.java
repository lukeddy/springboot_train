package com.yocool.autoconfig;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 配置映射文件
 */
@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "com.yocool.init.config")
public class GlobalConfig {
    private String testURL = "http://www.baidu.com";
    //以下是从属性文件application*.properties中自动映射
    private String app;
    private String env;
    private String myString;
    private Integer myInt;
}
