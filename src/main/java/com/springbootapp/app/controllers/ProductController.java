package com.springbootapp.app.controllers;

import com.springbootapp.app.dto.ProductDto;
import com.springbootapp.app.models.Product;
import com.springbootapp.app.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        List<ProductDto> products = productService.findAllProducts();
        model.addAttribute("products",products);
        return "products-index"; // resources/templates/products-index.html
    }

    @GetMapping("/products/{productId}")
    public String viewProduct(@PathVariable("productId") long productId, Model model){
        ProductDto productDto = productService.findProductById(productId);
        model.addAttribute("product", productDto);
        return "products-view";
    }

    @GetMapping("/products/create")
    public String createProductForm(Model model){
        Product product = new Product();
        model.addAttribute("product", product);
        return "products-create"; // resources/templates/products-create.html
    }

    @PostMapping("/products/create")
    public String createProduct(@ModelAttribute("product") Product product){
        productService.createProduct(product);
        return "redirect:/products";
    }

    @GetMapping("/products/{productId}/edit")
    public String editProductForm(@PathVariable("productId") long productId, Model model){
        ProductDto product = productService.findProductById(productId);
        model.addAttribute("product", product);
        return "products-edit"; // resources/templates/products-edit.html
    }

    @PostMapping("/products/{productId}/edit")
    public String editProduct(@PathVariable("productId") long productId, @ModelAttribute("product") ProductDto product){
        product.setId(productId);
        productService.editProduct(product);
        return "redirect:/products";
    }

    @PostMapping("/products/{productId}/delete")
    public String deleteProduct(@PathVariable("productId") long productId){
        productService.deleteProduct(productId);
        return "redirect:/products";
    }

    @GetMapping("products/search")
    public String searchProducts(@RequestParam(value = "query") String query, Model model){
        List<ProductDto> products = productService.searchProducts(query);
        model.addAttribute("products", products);
        return "products-index";
    }
}