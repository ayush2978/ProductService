package com.ayush.productservicespring.controller;

import com.ayush.productservicespring.models.Category;
import com.ayush.productservicespring.models.Product;
import com.ayush.productservicespring.service.CategoryServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class CategoryController {
    CategoryServiceImpl categoryService;
    CategoryController(CategoryServiceImpl categoryService){
        this.categoryService=categoryService;
    }
    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getCategories() {
        List<Category> categories=categoryService.getCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/category/{categoryName}")
    public String getCategory(@PathVariable("categoryName") String categoryName) {
        List<Product> productsOfACategory=categoryService.getProductsOfCategory(categoryName);
        return productsOfACategory.toString();
    }
}
