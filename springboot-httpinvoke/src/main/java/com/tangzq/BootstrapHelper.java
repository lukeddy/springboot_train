package com.tangzq;

import com.tangzq.config.AutoConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 服务器启动时运行方法
 * Author tangzq.
 */
@Component
public class BootstrapHelper implements ApplicationListener {

    private static final Logger logger = LoggerFactory.getLogger(BootstrapHelper.class);

    @Autowired
    private AutoConfig autoConfig;

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        logger.info("BootstrapHelper服务器启动成功，远程调用地址{}",autoConfig.getAppName());
    }
}
