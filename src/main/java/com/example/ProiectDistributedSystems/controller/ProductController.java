package com.example.ProiectDistributedSystems.controller;

import com.example.ProiectDistributedSystems.repository.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/product")
public class ProductController {


    private final ProductRepository productRepository;


    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @GetMapping
    public ResponseEntity getAllProducts() {
        System.out.println("getAllProducts");
        return ResponseEntity.ok(this.productRepository.findAll());
    }
}
