package com.yocool.service;

import com.yocool.model.Product;

import java.util.List;

/**
 * 接口层
 * Author tangzq.
 */
public interface ProductService {
    List<Product> getAllProd();
    Product getProdById(int id);
    void deleteProdById(int id);
    void addProduct(Product prod);
}
