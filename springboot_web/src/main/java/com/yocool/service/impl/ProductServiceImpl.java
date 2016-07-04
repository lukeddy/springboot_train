package com.yocool.service.impl;

import com.yocool.model.Product;
import com.yocool.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * 产品接口实现类
 * Author tangzq.
 */
@Service
public class ProductServiceImpl  implements ProductService{

    private List<Product> products=null;

    @PostConstruct
    public void initProducts(){
        products=new ArrayList();
        products.add(new Product(111,"MacBook","苹果公司","MacBook，设计一新，电池满足一天所需。立刻购买可享12期免息分期。 免费送货与退货。"));
        products.add(new Product(222,"Google Chrome","Google公司","Chromebook是Google推出的网络笔记本。这是一种全新的笔记本电脑，号称“完全在线”，能提供完善的网络应用服务。"));
        products.add(new Product(222,"Honor","中国华为","华为商城是华为旗下面向全国服务的电子商务平台官网,我们提供正品华为手机。"));
    }

    @Override
    public List<Product> getAllProd() {
        return products;
    }

    @Override
    public Product getProdById(int id) {
        for(Product prod:products){
            if(prod.getId()==id) return prod;
        }
        return null;
    }

    @Override
    public boolean isProdExist(int id) {
        for(Product prod:products){
            if(prod.getId()==id) return true;
        }
        return false;
    }

    @Override
    public void deleteProdById(int id) {
        for(Product prod:products){
            if(prod.getId()==id) products.remove(prod);
        }
    }

    @Override
    public void addProduct(Product prod) {
        products.add(prod);
    }
}
