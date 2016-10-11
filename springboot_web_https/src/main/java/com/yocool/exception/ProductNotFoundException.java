package com.yocool.exception;

/**
 * 自定义异常
 * Author tangzq.
 */
public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(int id) {
        super("产品("+id+")不存在异常");
    }
}
