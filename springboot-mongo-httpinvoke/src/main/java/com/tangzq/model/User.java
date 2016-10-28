package com.tangzq.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * 用户
 */
@Getter
@Setter
@ToString
@Document(collection = "temp_user")
public class User {

    @Id
    private String id;

    @Field("phone")
    private String phone;

    @Field("fullname")
    private String fullname;

    @Field("created_at")
    private Date createdAt;

    @Field("updated_at")
    private Date updatedAt;


}
