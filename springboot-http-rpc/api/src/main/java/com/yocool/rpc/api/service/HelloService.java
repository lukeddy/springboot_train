package com.yocool.rpc.api.service;

/**
 * RPC公共接口
 */
public interface HelloService {

    /**
     * RPC调用URI,统一放到接口里边
     */
    public static final String HTTP_RPC_URI = "/httpInvoke/HelloService/v1";

    /**
     *
     * @param s
     * @return
     */
    String sendMsg(String s);
}
