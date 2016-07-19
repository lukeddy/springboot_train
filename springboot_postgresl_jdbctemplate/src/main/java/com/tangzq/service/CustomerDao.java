package com.tangzq.service;

import com.tangzq.model.Customer;

import java.util.List;

/**
 * 接口类
 */
public interface CustomerDao {
    public void insert(Customer user);
    public List<Customer> findAll();
    public void update(Customer user);
    public void delete(int id);

    public boolean isExist(int id);
}
