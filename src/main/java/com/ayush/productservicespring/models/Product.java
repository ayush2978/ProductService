package com.ayush.productservicespring.models;

import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product extends BaseModel {
    private double price;
    private String title;
    private Category category;
    private String description;
    private String image;
}
