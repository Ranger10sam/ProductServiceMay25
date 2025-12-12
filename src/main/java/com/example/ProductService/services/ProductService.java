package com.example.ProductService.services;

import com.example.ProductService.models.Product;

import java.util.List;

public interface ProductService {

    Product getSingleProduct(Long productId);

    List<Product> getAllProduct();

    Product createProduct();

    boolean deleteProduct();
}
