package com.manoj.commerceservice.repository;

import com.manoj.commerceservice.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CommerceRepository {
    List<Product> productList = new ArrayList<>();

    public Product addProduct(Product product){
        productList.add(product);
        return product;
    }

    public List<Product> getProductList(){
        return productList;
    }

    public void getProductById(int productId){
    }
}
