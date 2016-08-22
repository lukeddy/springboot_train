package com.yocool.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Author tangzq.
 */
@Getter
@Setter
public class Product{

    private int id;
    private String prodName;
    private String prodCompany;
    private String prodDesc;

    public Product() {
    }

    public Product(int id, String prodName, String prodCompany, String prodDesc) {
        this.id = id;
        this.prodName = prodName;
        this.prodCompany = prodCompany;
        this.prodDesc = prodDesc;
    }
}
