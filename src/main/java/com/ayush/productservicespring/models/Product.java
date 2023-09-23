package com.ayush.productservicespring.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private String name;
    private double price;
    private String title;
    private Category category;
    private String description;
    private String image;
}
