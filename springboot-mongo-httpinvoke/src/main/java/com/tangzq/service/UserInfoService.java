package com.tangzq.service;

import com.tangzq.vo.UserInfoVo;

/**
 * 用户信息接口
 * Author tangzq
 */
public interface UserInfoService {

    /**
     * 定义 服务 Export 上下文
     */
   String HTTP_INVOKER_EXPORT_CONTEXT = "/HttpInvokerEndpoing/UserInfoService/v1";


    /**
     * 使用用户ID查询用户信息
     * @param userId
     * @return
     */
    UserInfoVo findUserInfoById(String userId);

    /**
     * 使用手机号查用户信息
     * @param phone
     * @return
     */
    UserInfoVo findUserInfoByPhone(String phone);

    /**
     * 使用用户ID查用户名
     * @param userId
     * @return
     */
    String findUserFullNameById(String userId);

    /**
     * 使用手机号查用户名
     * @param phone
     * @return
     */
    String findUserFullNameByPhone(String phone);

}
