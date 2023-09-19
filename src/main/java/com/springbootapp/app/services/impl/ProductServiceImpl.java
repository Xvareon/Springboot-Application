package com.springbootapp.app.services.impl;

import com.springbootapp.app.dto.ProductDto;
import com.springbootapp.app.mapper.ProductMapper;
import com.springbootapp.app.models.Product;
import com.springbootapp.app.repositories.ProductRepository;
import com.springbootapp.app.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.springbootapp.app.mapper.ProductMapper.mapToProduct;
import static com.springbootapp.app.mapper.ProductMapper.mapToProductDto;

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
        return products.stream().map(ProductMapper::mapToProductDto).collect(Collectors.toList());
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
}