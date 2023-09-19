package com.springbootapp.app.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDto {
    private int id;
    private String name;
    private int variant;
    private int qty;
    private double price;
    private String description;
}
