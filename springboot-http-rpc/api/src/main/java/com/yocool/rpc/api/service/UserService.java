package com.yocool.rpc.api.service;

import com.yocool.rpc.api.entity.User;

import java.util.List;

/**
 * RPC公共接口
 */
public interface UserService {

    /**
     * RPC调用URI,统一放到接口里边
     */
    public static final String HTTP_RPC_URI = "/httpInvoke/UserService/v1";

    String test(String input);

    List<User> listUsers();

    User createUser(String name, int age);
}
