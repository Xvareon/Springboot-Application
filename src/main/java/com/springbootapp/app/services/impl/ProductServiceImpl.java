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
        List<Product> products = productRepository.findAllByOrderById();
        return products.stream().map(ProductMapper::mapToProductDto).collect(Collectors.toList());
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public ProductDto findProductById(long productId){
        Product product = productRepository.findById(productId).get();
        return mapToProductDto(product);
    }

    @Override
    public void editProduct(ProductDto productDto) {
        Product product = mapToProduct(productDto);
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(long productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public List<ProductDto> searchProducts(String query) {
        List<Product> products = productRepository.searchProducts(query);
        return products.stream().map(ProductMapper::mapToProductDto).collect(Collectors.toList());
    }
}
