package com.tangzq.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Author tangzq.
 */
@Configuration
@ConfigurationProperties(prefix = "com.tangzq.client.config")
public class Config4Test {
    private String remoteEndPoint;

    public String getRemoteEndPoint() {
        return remoteEndPoint;
    }

    public void setRemoteEndPoint(String remoteEndPoint) {
        this.remoteEndPoint = remoteEndPoint;
    }
}
