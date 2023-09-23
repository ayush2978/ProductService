package com.ayush.productservicespring.service;

import com.ayush.productservicespring.models.Category;
import com.ayush.productservicespring.models.CategoryDTO;
import com.ayush.productservicespring.models.Product;
import com.ayush.productservicespring.models.ProductDTO;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductServiceImpl implements ProductService {
    private RestTemplate restTemplate;
    ProductServiceImpl(RestTemplate restTemplate){
        this.restTemplate=restTemplate;
    }
    @Override
    public Product getProduct(long productId) {
        ResponseEntity<ProductDTO> productDTOResponseEntity =restTemplate.getForEntity("https://fakestoreapi.com/products/{productId}", ProductDTO.class,productId);
        ProductDTO productDTO=productDTOResponseEntity.getBody();
        Product product=new Product();
        product.setTitle(productDTO.getTitle());
        product.setPrice(productDTO.getPrice());
        product.setImage(productDTO.getImage());
        product.setDescription(productDTO.getDescription());
        Category category=new Category();
        category.setName(productDTO.getCategory());
        product.setCategory(category);
        return product;
    }

    @Override
    public Product createProduct(ProductDTO product) {
        ResponseEntity<ProductDTO> response=restTemplate.postForEntity("https://fakestoreapi.com/products",product,ProductDTO.class);
        ProductDTO productDTO=response.getBody();
        Product product1=new Product();
        product1.setTitle(productDTO.getTitle());
        product1.setPrice(productDTO.getPrice());
        product1.setImage(productDTO.getImage());
        product1.setDescription(productDTO.getDescription());
        Category category=new Category();
        category.setName(productDTO.getCategory());
        product1.setCategory(category);
        return product1;
    }


}