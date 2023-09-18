package com.springbootapp.app.services.impl;

import com.springbootapp.app.dto.ProductDto;
import com.springbootapp.app.models.Product;
import com.springbootapp.app.repositories.ProductRepository;
import com.springbootapp.app.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    @Override
    public List<ProductDto> findALlProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(this::mapToProductDto).collect(Collectors.toList());
    }

    private ProductDto mapToProductDto(Product product){
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .variant(product.getVariant())
                .qty(product.getQty())
                .price(product.getPrice())
                .description(product.getDescription())
                .build();
    }
}
