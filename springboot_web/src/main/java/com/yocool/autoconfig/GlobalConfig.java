package com.yocool.autoconfig;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * 配置映射文件
 */
@ConfigurationProperties(prefix = "com.yocool.init.config")
public class GlobalConfig {
    private String testURL = "http://www.baidu.com";
    //以下是从属性文件application*.properties中自动映射
    private String app;
    private String env;
    private String myString;
    private Integer myInt;


    private Map<String, String> myMap = new HashMap<String, String>();

    public void setTestURL(String testURL) {
        this.testURL = testURL;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public void setMyString(String myString) {
        this.myString = myString;
    }

    public void setMyInt(Integer myInt) {
        this.myInt = myInt;
    }

    public void setMyMap(Map<String, String> myMap) {
        this.myMap = myMap;
    }
}
