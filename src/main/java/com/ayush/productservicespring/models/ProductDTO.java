package com.ayush.productservicespring.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
    private long id;
    private String title;
    private double price;
    private Category category;
    private String  description;
    private String image;
}
