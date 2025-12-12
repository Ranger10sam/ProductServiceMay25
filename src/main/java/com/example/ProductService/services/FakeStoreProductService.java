package com.example.ProductService.services;

import com.example.ProductService.dtos.FakeStoreProductDto;
import com.example.ProductService.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

//Note : This service class with implement all the APIs using FakeStore
@Service
public class FakeStoreProductService implements ProductService{

    RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getSingleProduct(Long productId) {
        ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoResponseEntity = restTemplate.getForEntity(
                "https://fakestoreapi.com/products/"+productId,
                FakeStoreProductDto.class );
        FakeStoreProductDto fakeStoreProductDto = fakeStoreProductDtoResponseEntity.getBody();

        System.out.println(fakeStoreProductDto);
        return convertFakeStoreProductDtoToProduct(fakeStoreProductDto);
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

    private static Product convertFakeStoreProductDtoToProduct(FakeStoreProductDto fakeStoreProductDto){

        if(fakeStoreProductDto==null){
            return null;
        }

        Product product = new Product();
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setId(fakeStoreProductDto.getId());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setImage(fakeStoreProductDto.getImageUrl());
        product.setCategory(fakeStoreProductDto.getCategory());

        return product;
    }
}
