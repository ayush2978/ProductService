package com.ayush.productservicespring.models.dtos;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class CategoryDTO {
    private String name;
    private String description;
}
