package com.ayush.productservicespring.repository;

import com.ayush.productservicespring.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product save(Product product);
}
