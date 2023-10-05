package com.ayush.productservicespring.service;

import com.ayush.productservicespring.models.Category;
import com.ayush.productservicespring.models.Product;

import java.util.List;

public interface CategoryService {
    public List<Category> getCategories();
    public List<Product> getProductsOfCategory(String categoryName);
}
