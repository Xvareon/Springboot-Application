package com.springbootapp.app.controllers;

import com.springbootapp.app.dto.ProductDto;
import com.springbootapp.app.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/products")
    public  String listProducts(Model model){
        List<ProductDto> products = productService.findALlProducts();
        model.addAttribute("products",products);
        return "index"; // resources/templates/index.html
    }
}
