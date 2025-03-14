package com.example.ktmshop.service;

import com.example.ktmshop.dto.ProductRequest;
import com.example.ktmshop.dto.ProductResponse;
import com.example.ktmshop.model.Product;
import com.example.ktmshop.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public ProductResponse createProduct(ProductRequest productRequest){
        Product product = Product.builder()
                .name(productRequest.name())
                .description(productRequest.description())
                .price(productRequest.price())
                .skuCode(productRequest.skuCode())
                .build();

            log.info("product created successfully");
         productRepository.save(product);
         return new ProductResponse(product.getId(),product.getName(),product.getDescription(),product.getPrice(),product.getSkuCode());


    }


    public List<ProductResponse> getAll() {
        log.info("FindAll executed");
        return productRepository.findAll()
                .stream()
                .map(product -> new ProductResponse(product.getId(),product.getName(),product.getDescription(),product.getPrice(), product.getSkuCode()))
                .toList();
    }
}
