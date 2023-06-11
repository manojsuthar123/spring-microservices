package com.manoj.commerceservice.service;

import com.manoj.commerceservice.entity.Product;

import java.util.List;

public interface CommerceService {
    List<Product> getAllProducts();
    Product addProduct(Product product);
}
