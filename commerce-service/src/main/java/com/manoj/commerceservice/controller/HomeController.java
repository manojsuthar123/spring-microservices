package com.manoj.commerceservice.controller;

import com.manoj.commerceservice.entity.Product;
import com.manoj.commerceservice.repository.CommerceRepository;
import com.manoj.commerceservice.service.CommerceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {

    @Autowired
    private CommerceService commerceService;

    @GetMapping("/start")
    public ResponseEntity<String> start(){
        return new ResponseEntity<>("E-Commerce is working", HttpStatus.OK);
    }

    @GetMapping("/product")
    public List<Product> getProducts(){
        return commerceService.getAllProducts();
    }

    @PostMapping("/product")
    public Product addProduct(@RequestBody Product product){
        return commerceService.addProduct(product);
    }
}
