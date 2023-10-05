package com.ayush.productservicespring.service;

import com.ayush.productservicespring.client.fakestoreclient.FakeStoreApiClient;
import com.ayush.productservicespring.client.fakestoreclient.ProductCategoryServiceImpl;
import com.ayush.productservicespring.models.Category;
import com.ayush.productservicespring.models.Product;
import com.ayush.productservicespring.client.fakestoreclient.FakeStoreProductDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    ProductCategoryServiceImpl productCategoryService;
    FakeStoreApiClient fakeStoreApiClient;

    CategoryServiceImpl(ProductCategoryServiceImpl productCategoryService,FakeStoreApiClient fakeStoreApiClient){
        this.productCategoryService=productCategoryService;
        this.fakeStoreApiClient=fakeStoreApiClient;
    }
    @Override
    public List<String> getCategories() {
        String[] categoryDTOS= fakeStoreApiClient.getCategories();
        List<String> categories=new ArrayList<>();
        Collections.addAll(categories, categoryDTOS);
        return categories;
    }

    @Override
    public List<Product> getProductsOfCategory(String categoryName) {
        FakeStoreProductDTO[] fakeStoreProductDTOS= fakeStoreApiClient.getProductsOfCategory(categoryName);
        List<Product> categories=new ArrayList<>();
        for(FakeStoreProductDTO categoryDTO:fakeStoreProductDTOS){
            Product product=new Product();
            product.setTitle(categoryDTO.getTitle());
            product.setPrice(categoryDTO.getPrice());
            product.setImage(categoryDTO.getImage());
            product.setDescription(categoryDTO.getDescription());
            Category category=new Category();
            category.setName(categoryDTO.getCategory());
            product.setCategory(category);
            categories.add(product);
        }
        return categories;
    }
}
