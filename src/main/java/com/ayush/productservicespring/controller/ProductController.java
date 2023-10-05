package com.ayush.productservicespring.controller;

import com.ayush.productservicespring.exceptions.NotFoundException;
import com.ayush.productservicespring.models.Category;
import com.ayush.productservicespring.models.Product;
import com.ayush.productservicespring.models.dtos.ProductDTO;
import com.ayush.productservicespring.service.ProductServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Product> getProduct(@PathVariable("productId") long productId) throws NotFoundException {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("auth-token", "1341233412");
        ResponseEntity<Product> response=null;
        try {
            response = new ResponseEntity<>(productService.getProduct(productId), headers, HttpStatus.OK);
        }catch (Exception e){
            throw new NotFoundException("Product not found");
        }
        return response;
    }
    @PostMapping()
    public ResponseEntity<Product> createProduct(@RequestBody ProductDTO productDTO) {
        Product product=new Product();
        product.setTitle(productDTO.getTitle());
        product.setPrice(productDTO.getPrice());
        product.setImage(productDTO.getImage());
        product.setDescription(productDTO.getDescription());
        product.setCategory(new Category());
        product.getCategory().setName(productDTO.getCategory());
        product=productService.createProduct(product);
        return new ResponseEntity<>(product,HttpStatus.OK);
    }
    @PatchMapping("/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable("productId") long productId, @RequestBody ProductDTO productDTO){
        Product product=new Product();
        product.setTitle(productDTO.getTitle());
        product.setPrice(productDTO.getPrice());
        product.setImage(productDTO.getImage());
        product.setDescription(productDTO.getDescription());
        product.setCategory(new Category());
        product.getCategory().setName(productDTO.getCategory());
        Product updatedProduct=productService.updateProduct(productId,product);
        ResponseEntity<Product> response=new ResponseEntity<>(updatedProduct,HttpStatus.OK);
        return response;
    }
    @PutMapping("/{productId}")
    public ResponseEntity<Product> replaceProduct(@PathVariable("productId") long productId, @RequestBody ProductDTO productDTO){
        Product product=new Product();
        product.setTitle(productDTO.getTitle());
        product.setPrice(productDTO.getPrice());
        product.setImage(productDTO.getImage());
        product.setDescription(productDTO.getDescription());
        product.setCategory(new Category());
        product.getCategory().setName(productDTO.getCategory());
        Product updatedProduct=productService.replaceProduct(productId,product);
        return new ResponseEntity<>(updatedProduct,HttpStatus.OK);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Product> deleteProduct(@PathVariable("productId") String productId) {
        Product product=productService.deleteProduct(Long.parseLong(productId));
        return new ResponseEntity<>(product,HttpStatus.OK);
    }
}
