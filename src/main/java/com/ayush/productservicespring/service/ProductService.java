package com.ayush.productservicespring.service;

import com.ayush.productservicespring.models.Product;
import com.ayush.productservicespring.models.ProductDTO;

public interface ProductService {
    public Product getProduct(long productId);
    public Product createProduct(ProductDTO product);
}
