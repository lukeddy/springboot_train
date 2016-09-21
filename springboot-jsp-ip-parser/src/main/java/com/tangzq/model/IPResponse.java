package com.tangzq.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

/**
 * IP解析封装类
 */
@Getter
@Setter
@ToString
public class IPResponse {
    private Integer errNum;
    private String errMsg;
    private Object retData;
}
