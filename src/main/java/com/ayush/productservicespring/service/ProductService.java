package com.ayush.productservicespring.service;

import com.ayush.productservicespring.models.Product;
import com.ayush.productservicespring.models.ProductDTO;

import java.util.List;

public interface ProductService {
    public Product getProduct(long productId);
    public Product createProduct(ProductDTO product);

    public List<Product> getAllProducts();

    public void updateProduct(long productId,ProductDTO productDTO);

    public void deleteProduct(long productId);
}
