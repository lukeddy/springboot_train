package com.yocool.rpc.server.service;

import com.yocool.rpc.api.service.HelloService;
import org.springframework.stereotype.Service;


@Service
public class DemoServiceImpl  implements HelloService {

    @Override
    public String sendMsg(String s) {
        return "收到客户端发的内容:"+s;
    }
}
