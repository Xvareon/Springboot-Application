package com.springbootapp.app.services;

import com.springbootapp.app.dto.ProductDto;
import com.springbootapp.app.models.Product;

import java.util.List;

public interface ProductService {
    List<ProductDto> findALlProducts();

    Product createProduct(Product product);

    ProductDto findProductById(long productId);

    void editProduct(ProductDto product);
}
