package com.manoj.commerceservice.service.impl;

import com.manoj.commerceservice.aspect.DisplayParameter;
import com.manoj.commerceservice.aspect.LogReturnValue;
import com.manoj.commerceservice.entity.Product;
import com.manoj.commerceservice.repository.CommerceRepository;
import com.manoj.commerceservice.service.CommerceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommerceServiceImpl implements CommerceService {

    @Autowired
    private CommerceRepository commerceRepository;

    @DisplayParameter
    @LogReturnValue
    @Override
    public List<Product> getAllProducts() {
        return commerceRepository.getProductList();
    }

    @Override
    public Product addProduct(Product product) {
        return commerceRepository.addProduct(product);
    }
}
