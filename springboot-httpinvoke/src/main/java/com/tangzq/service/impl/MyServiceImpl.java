package com.tangzq.service.impl;

import com.tangzq.service.MyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * MyService接口实现类
 * Author tangzq.
 */
@Service
public class MyServiceImpl implements MyService {

    private static final Logger logger = LoggerFactory.getLogger(MyServiceImpl.class);

    @Override
    public int add(int num1, int num2) {

        logger.info("发起了远程调用，传递的参数为{},{}",num1,num2);
        return num1+num2;
    }

    @Override
    public String getMsg(String name) {
        logger.info("发起了远程调用，传递的参数为{}",name);
        return "你好："+name;
    }
}
