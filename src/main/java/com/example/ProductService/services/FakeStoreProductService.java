package com.example.ProductService.services;

import com.example.ProductService.dtos.FakeStoreProductDto;
import com.example.ProductService.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
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

        ResponseEntity<FakeStoreProductDto[]> allFakeStoreProductDto = restTemplate.getForEntity(
                "https://fakestoreapi.com/products",
                FakeStoreProductDto[].class
        );

        FakeStoreProductDto[] fakeStoreProductDto = allFakeStoreProductDto.getBody();
        List<Product> products = new ArrayList<>();

        assert fakeStoreProductDto != null;
        for(FakeStoreProductDto i : fakeStoreProductDto){
            products.add(convertFakeStoreProductDtoToProduct(i));
        }

        return products;
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
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setImage(fakeStoreProductDto.getImage());
        product.setCategory(fakeStoreProductDto.getCategory());

        return product;
    }
}
