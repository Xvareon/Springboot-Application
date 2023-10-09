package com.springbootapp.app.services;

import com.springbootapp.app.dto.ProductDto;
import com.springbootapp.app.models.Product;

import java.util.List;

public interface ProductService {
    List<ProductDto> findAllProducts();

    Product createProduct(Product product);

    ProductDto findProductById(long productId);

    void editProduct(ProductDto product);

    void deleteProduct(long productId);

    List<ProductDto> searchProducts(String query);
}
