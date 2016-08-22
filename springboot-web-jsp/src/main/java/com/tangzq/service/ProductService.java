package com.tangzq.service;

import com.tangzq.model.Product;

import java.util.List;

/**
 * 接口层
 * Author tangzq.
 */
public interface ProductService {
    List<Product> getAllProd();
    Product getProdById(int id);
    boolean isProdExist(int id);
    void deleteProdById(int id);
    void addProduct(Product prod);
}
