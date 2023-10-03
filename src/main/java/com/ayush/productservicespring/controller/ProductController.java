package com.ayush.productservicespring.controller;

import com.ayush.productservicespring.models.Product;
import com.ayush.productservicespring.models.ProductDTO;
import com.ayush.productservicespring.service.ProductServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/products")
public class ProductController {
    ProductServiceImpl productService;

    ProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @GetMapping()
    public List<Product> getProducts() {
        log.debug("Enter getProducts() method");
        return productService.getAllProducts();
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable("productId") long productId) {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("auth-token", "1341233412");

        ResponseEntity<Product> response=new ResponseEntity<>(productService.getProduct(productId), headers,HttpStatus.OK);
        return response;
    }

    @PostMapping()
    public ResponseEntity<Product> createProduct(@RequestBody ProductDTO productDTO) {
        Product product=productService.createProduct(productDTO);
        ResponseEntity<Product> response=new ResponseEntity<>(product,HttpStatus.OK);
        return response;
    }

    @PutMapping("/{productId}")
    public ResponseEntity<String> updateProduct(@PathVariable("productId") long productId, @RequestBody ProductDTO productDTO){
        productService.updateProduct(productId,productDTO);
        ResponseEntity<String> response=new ResponseEntity<>("Product updated",HttpStatus.OK);
        return response;
    }

    @DeleteMapping("/{productId}")
    public String deleteProduct(@PathVariable("productId") String productId) {
        productService.deleteProduct(Long.parseLong(productId));
        return "Product deleted";
    }
}
