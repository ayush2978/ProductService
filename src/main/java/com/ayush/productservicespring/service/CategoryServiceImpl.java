package com.ayush.productservicespring.service;

import com.ayush.productservicespring.models.Category;
import com.ayush.productservicespring.models.CategoryDTO;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.swing.text.Caret;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    RestTemplate restTemplate=null;

    CategoryServiceImpl(RestTemplate restTemplate){
        this.restTemplate=restTemplate;
    }
    @Override
    public List<Category> getCategories() {
        ResponseEntity<CategoryDTO[]> categoryResponseEntity=restTemplate.getForEntity("https://fakestoreapi.com/products/categories", CategoryDTO[].class);
        CategoryDTO[] categoryDTOS=categoryResponseEntity.getBody();
        List<Category> categories=null;
        for(CategoryDTO categoryDTO:categoryDTOS){
            Category category=new Category();
            category.setName(categoryDTO.getName());
            category.setDescription(categoryDTO.getDescription());
            categories.add(category);
        }
        return categories;
    }

    @Override
    public List<Category> getProductsOfCategory(String categoryName) {
        ResponseEntity<CategoryDTO[]> response=restTemplate.getForEntity("https://fakestoreapi.com/products/category/{categoryName}",CategoryDTO[].class,categoryName);
        CategoryDTO[] categoryDTOS=response.getBody();
        List<Category> categories=null;
        for(CategoryDTO categoryDTO:categoryDTOS){
            Category category=new Category();
            category.setName(categoryDTO.getName());
            category.setDescription(categoryDTO.getDescription());
            categories.add(category);
        }
        return categories;
    }
}
