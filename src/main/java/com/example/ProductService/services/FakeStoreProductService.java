package com.example.ProductService.services;

import com.example.ProductService.models.Product;

import java.util.List;

public class FakeStoreProductService implements ProductService{
    //Note : This service class with implement all the APIs using FakeStore

    @Override
    public Product getSingleProduct() {
        return null;
    }

    @Override
    public List<Product> getAllProduct() {
        return List.of();
    }

    @Override
    public Product createProduct() {
        return null;
    }

    @Override
    public boolean deleteProduct() {
        return false;
    }
}
