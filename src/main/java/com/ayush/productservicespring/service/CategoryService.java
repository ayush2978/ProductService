package com.ayush.productservicespring.service;

import com.ayush.productservicespring.models.Product;

import java.util.List;

public interface CategoryService {
    public List<String> getCategories();
    public List<Product> getProductsOfCategory(String categoryName);
}
