package com.tangzq.producer.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 产品Model类
 */
public class Product implements Serializable{

    private int id;
    private String name;
    private String company;
    private Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Product() {
    }

    public Product(int id, String name, String company, Date date) {
        this.id = id;
        this.name = name;
        this.company = company;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", date=" + date +
                '}';
    }
}
