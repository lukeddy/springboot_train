package com.tangzq.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * Vo类，用于值封装传递
 */
@Getter
@Setter
@ToString
public class UserInfoVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String phone;

    private String fullname;

    private Date createdAt;

    private Date updatedAt;

}
