package com.yocool.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 配置映射文件
 */
@ConfigurationProperties(prefix = "com.yocool.config")
public class MyProperties {
    private String testURL = "http://www.baidu.com";
    private String defaultProperties = "你好我是属性值";

    //以下是从属性文件application.properties中自动映射
    private String env;
    private String app;
    private String myConfig1;
    private Integer myConfig2;
    private Map<String, String> myMap = new HashMap<String, String>();


    //YML配置
    private List<Person> personList;


    //静态内部类
    public static class Person {
        private String name;
        private String gender;
        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender='" + gender + '\'' +
                    ", age=" + age +
                    '}';
        }
    }




    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public String getTestURL() {
        return testURL;
    }

    public void setTestURL(String testURL) {
        this.testURL = testURL;
    }

    public String getDefaultProperties() {
        return defaultProperties;
    }

    public void setDefaultProperties(String defaultProperties) {
        this.defaultProperties = defaultProperties;
    }

    public String getMyConfig1() {
        return myConfig1;
    }

    public void setMyConfig1(String myConfig1) {
        this.myConfig1 = myConfig1;
    }

    public Integer getMyConfig2() {
        return myConfig2;
    }

    public void setMyConfig2(Integer myConfig2) {
        this.myConfig2 = myConfig2;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public Map<String, String> getMyMap() {
        return myMap;
    }

    public void setMyMap(Map<String, String> myMap) {
        this.myMap = myMap;
    }
}
