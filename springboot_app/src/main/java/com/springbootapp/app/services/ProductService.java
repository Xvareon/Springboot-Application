package com.springbootapp.app.services;

import com.springbootapp.app.dto.ProductDto;
import java.util.List;

public interface ProductService {
    List<ProductDto> findALlProducts();
}
