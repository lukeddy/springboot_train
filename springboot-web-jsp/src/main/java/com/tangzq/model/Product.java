package com.tangzq.model;

/**
 * Author tangzq.
 */
public class Product {

    private int id;
    private String prodName;
    private String prodCompany;
    private String prodDesc;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getProdCompany() {
        return prodCompany;
    }

    public void setProdCompany(String prodCompany) {
        this.prodCompany = prodCompany;
    }

    public String getProdDesc() {
        return prodDesc;
    }

    public void setProdDesc(String prodDesc) {
        this.prodDesc = prodDesc;
    }

    public Product() {
    }

    public Product(int id, String prodName, String prodCompany, String prodDesc) {
        this.id = id;
        this.prodName = prodName;
        this.prodCompany = prodCompany;
        this.prodDesc = prodDesc;
    }
}
