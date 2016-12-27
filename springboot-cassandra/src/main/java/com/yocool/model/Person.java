package com.yocool.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Table("person")
public class Person {

    @PrimaryKey
    private String id;
    private String name;
    private int age;
}