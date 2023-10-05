package com.ayush.productservicespring.service;

import com.ayush.productservicespring.exceptions.NotFoundException;
import com.ayush.productservicespring.models.Product;
import com.ayush.productservicespring.models.dtos.ProductDTO;

import java.util.List;

public interface ProductService {
    public Product getProduct(long productId) throws NotFoundException;
    public Product createProduct(Product product);

    public List<Product> getAllProducts();

    public Product updateProduct(long productId,Product product);

    public Product replaceProduct(long productId,Product product);

    public Product deleteProduct(long productId);
}
