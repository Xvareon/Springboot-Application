package com.springbootapp.app.controllers;

import com.springbootapp.app.models.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class ProductAPIController {

    @GetMapping("productapi")
    public ResponseEntity<List<Product>> getProducts(){
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "TestProduct1", 1, 5, 10.00, "Product Number One"));
        products.add(new Product(2, "TestProduct2", 1, 7, 30.00, "Product Number Two"));
        products.add(new Product(3, "TestProduct3", 4, 11, 100.00, "Product Number Three"));
        return ResponseEntity.ok(products);
    }

    @GetMapping("productapi/{id}")
    public Product productDetail(@PathVariable long id){
        return new Product(id,"SampleData",6,5,4.00,"NotConnectedToDB");
    }

    @PostMapping("productapi/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        System.out.println(product.getName());
        System.out.println(product.getVariant());
        System.out.println(product.getQty());
        System.out.println(product.getPrice());
        System.out.println(product.getDescription());
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @PutMapping("productapi/{id}/update")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable("id") long productId){
        System.out.println(product.getName());
        System.out.println(product.getVariant());
        System.out.println(product.getQty());
        System.out.println(product.getPrice());
        System.out.println(product.getDescription());
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("productapi/{id}/delete")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") long productId){
        System.out.println(productId);
        return ResponseEntity.ok("Product Deleted Successfully");
    }
}