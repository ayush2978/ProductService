package com.ayush.productservicespring.controller;

import com.ayush.productservicespring.models.Product;
import com.ayush.productservicespring.models.ProductDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping()
    public String getProducts() {
        return "All products";
    }

    @GetMapping("/{productId}")
    public String getProduct(@PathVariable("productId") String productId) {
        return "returning product: "+productId;
    }

    @PostMapping()
    public String createProduct() {
        return "Product created";
    }

    @PutMapping("/{productId}")
    public String updateProduct(@PathVariable("productId") String productId) {
        return "Product updated";
    }

    @DeleteMapping("/{productId}")
    public String deleteProduct(@PathVariable("productId") String productId) {
        return "Product deleted";
    }
}
