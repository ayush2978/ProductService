package com.ayush.productservicespring.service;

import com.ayush.productservicespring.client.fakestoreclient.FakeStoreApiClient;
import com.ayush.productservicespring.client.fakestoreclient.ProductCategoryServiceImpl;
import com.ayush.productservicespring.models.Category;
import com.ayush.productservicespring.models.Product;
import com.ayush.productservicespring.client.fakestoreclient.FakeStoreCategoryDTO;
import com.ayush.productservicespring.client.fakestoreclient.FakeStoreProductDTO;
import org.springframework.stereotype.Service;

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
    public List<Category> getCategories() {
        FakeStoreCategoryDTO[] categoryDTOS= fakeStoreApiClient.getCategories();
        List<Category> categories=null;
        for(FakeStoreCategoryDTO categoryDTO:categoryDTOS){
            Category category=new Category();
            category.setName(categoryDTO.getName());
            category.setDescription(categoryDTO.getDescription());
            categories.add(category);
        }
        return categories;
    }

    @Override
    public List<Product> getProductsOfCategory(String categoryName) {
        FakeStoreProductDTO[] fakeStoreProductDTOS= fakeStoreApiClient.getProductsOfCategory(categoryName);
        List<Product> categories=null;
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
