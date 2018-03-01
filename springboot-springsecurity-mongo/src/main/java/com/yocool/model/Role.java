package com.yocool.model;

import lombok.Data;
import org.springframework.data.annotation.Id;


@Data
public class Role {
    @Id
    private String id;
    private String name;
}
