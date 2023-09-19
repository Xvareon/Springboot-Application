package com.springbootapp.app.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDto {
    private long id;
    private String name;
    private int variant;
    private int qty;
    private double price;
    private String description;
}
