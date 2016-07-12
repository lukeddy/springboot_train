package com.tangzq.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * 配置映射文件
 */
@Configuration
@ConfigurationProperties(prefix = "com.tangzq.my-config")
public class GlobalConfig {
    private String testURL = "http://www.baidu.com";
    //以下是从属性文件application*.properties中自动映射
    private String app;
    private String env;
    private String myString;
    private Integer myInt;


    private Map<String, String> myMap = new HashMap<String, String>();

    public String getTestURL() {
        return testURL;
    }

    public void setTestURL(String testURL) {
        this.testURL = testURL;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    public String getMyString() {
        return myString;
    }

    public void setMyString(String myString) {
        this.myString = myString;
    }

    public Integer getMyInt() {
        return myInt;
    }

    public void setMyInt(Integer myInt) {
        this.myInt = myInt;
    }

    public Map<String, String> getMyMap() {
        return myMap;
    }

    public void setMyMap(Map<String, String> myMap) {
        this.myMap = myMap;
    }
}
