package com.manoj.commerceservice.repository;

import com.manoj.commerceservice.entity.Product;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CommerceRepository {
    List<Product> productList = new ArrayList<>();
    @PostConstruct
    private void init(){
        productList.add(new Product(1,"iPhone 14 Pro Max", 175999.99));
        productList.add(new Product(2,"iPhone 14 Pro", 99999.99));
        productList.add(new Product(3,"iPhone 14", 75999.99));
        productList.add(new Product(4,"iPhone 13 mini", 65999.99));
    }

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
