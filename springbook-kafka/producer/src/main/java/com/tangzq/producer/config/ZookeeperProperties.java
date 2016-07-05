package com.tangzq.producer.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("zookeeper")
public class ZookeeperProperties {
    private String zookeeperHosts;
    private int sessionTimeoutMs;
    private int connectionTimeoutMs;

    public String getZookeeperHosts() {
        return zookeeperHosts;
    }

    public void setZookeeperHosts(String zookeeperHosts) {
        this.zookeeperHosts = zookeeperHosts;
    }

    public int getSessionTimeoutMs() {
        return sessionTimeoutMs;
    }

    public void setSessionTimeoutMs(int sessionTimeoutMs) {
        this.sessionTimeoutMs = sessionTimeoutMs;
    }

    public int getConnectionTimeoutMs() {
        return connectionTimeoutMs;
    }

    public void setConnectionTimeoutMs(int connectionTimeoutMs) {
        this.connectionTimeoutMs = connectionTimeoutMs;
    }

}
