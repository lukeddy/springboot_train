package com.yocool.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * Author tangzq.
 */
@Document(collection = "customers_collection")
public class Customer extends BaseModel<String>{

    private String firstName;
    private String lastName;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.setCreateAt(new Date());
    }

    @Override
    public String toString() {
        return "Customer{" +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean isNew() {
        return getId()==null;
    }
}
