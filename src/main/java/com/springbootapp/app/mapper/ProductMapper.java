package com.springbootapp.app.mapper;

import com.springbootapp.app.dto.ProductDto;
import com.springbootapp.app.models.Product;

public class ProductMapper {
    public static Product mapToProduct(ProductDto product) {
        return Product.builder()
                .id(product.getId())
                .name(product.getName())
                .variant(product.getVariant())
                .qty(product.getQty())
                .price(product.getPrice())
                .description(product.getDescription())
                .build();
    }

    public static ProductDto mapToProductDto(Product product) {
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
