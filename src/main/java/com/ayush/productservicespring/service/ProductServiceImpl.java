package com.ayush.productservicespring.service;

import com.ayush.productservicespring.client.fakestoreclient.FakeStoreApiClient;
import com.ayush.productservicespring.client.fakestoreclient.ProductCategoryServiceImpl;
import com.ayush.productservicespring.exceptions.NotFoundException;
import com.ayush.productservicespring.models.Category;
import com.ayush.productservicespring.models.Product;
import com.ayush.productservicespring.client.fakestoreclient.FakeStoreProductDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ProductServiceImpl implements ProductService {
    ProductCategoryServiceImpl productCategoryService;
    FakeStoreApiClient fakeStoreApiClient;
    ProductServiceImpl(ProductCategoryServiceImpl productCategoryService,FakeStoreApiClient fakeStoreApiClient){
        this.productCategoryService=productCategoryService;
        this.fakeStoreApiClient=fakeStoreApiClient;
    }

    private Product convertProductDTOToProduct(FakeStoreProductDTO productDTO){
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
    public Product getProduct(long productId) throws NotFoundException {
        FakeStoreProductDTO productDTO= fakeStoreApiClient.getProduct(productId);
        return convertProductDTOToProduct(productDTO);
    }

    @Override
    public Product createProduct(Product product) {
        FakeStoreProductDTO productDTO= fakeStoreApiClient.createProduct(product);
        return convertProductDTOToProduct(productDTO);
    }

    @Override
    public List<Product> getAllProducts() {
        FakeStoreProductDTO[] productDTOS= fakeStoreApiClient.getAllProducts();
        List<Product> answer=new ArrayList<>();
        for(FakeStoreProductDTO productDTO:productDTOS){
            answer.add(convertProductDTOToProduct(productDTO));
        }
        return answer;
    }

    @Override
    public Product updateProduct(long productId,Product product) {
        ResponseEntity<FakeStoreProductDTO> fakeStoreProductDTOResponseEntity=fakeStoreApiClient.updateProduct(productId,product);
        return convertProductDTOToProduct(Objects.requireNonNull(fakeStoreProductDTOResponseEntity.getBody()));
    }

    @Override
    public Product replaceProduct(long productId, Product product) {
        ResponseEntity<FakeStoreProductDTO> fakeStoreProductDTOResponseEntity=fakeStoreApiClient.replaceProduct(productId,product);
        return convertProductDTOToProduct(Objects.requireNonNull(fakeStoreProductDTOResponseEntity.getBody()));
    }

    @Override
    public Product deleteProduct(long productId) {
        ResponseEntity<FakeStoreProductDTO> fakeStoreProductDTOResponseEntity=fakeStoreApiClient.deleteProduct(productId);
        return convertProductDTOToProduct(Objects.requireNonNull(fakeStoreProductDTOResponseEntity.getBody()));
    }
}
