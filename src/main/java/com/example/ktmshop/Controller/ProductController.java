package com.example.ktmshop.Controller;

import com.example.ktmshop.dto.ProductRequest;
import com.example.ktmshop.dto.ProductResponse;
import com.example.ktmshop.model.Product;
import com.example.ktmshop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {
   private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse createProduct(@RequestBody ProductRequest productRequest){
            return productService.createProduct(productRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAll(){
        return productService.getAll();

    }
}
