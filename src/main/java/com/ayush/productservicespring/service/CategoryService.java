package com.ayush.productservicespring.service;

import com.ayush.productservicespring.models.Category;

import java.util.List;

public interface CategoryService {
    public List<Category> getCategories();
    public List<Category> getProductsOfCategory(String categoryName);
}
