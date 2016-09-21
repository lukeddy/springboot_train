package com.tangzq.service;

import com.tangzq.model.IPResponse;

/**
 * IP操作接口
 */
public interface IPService {

    /**
     * 查询IP详情
     * @param ip
     * @return
     */
    IPResponse queryByIP(String ip) throws Exception;
}
