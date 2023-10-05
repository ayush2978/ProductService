package com.ayush.productservicespring.client.fakestoreclient;

import com.ayush.productservicespring.exceptions.NotFoundException;
import com.ayush.productservicespring.models.Product;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class FakeStoreApiClient {
    ProductCategoryServiceImpl productCategoryService=null;

    FakeStoreApiClient(ProductCategoryServiceImpl productCategoryService){
        this.productCategoryService=productCategoryService;
    }
    public FakeStoreProductDTO getProduct(long productId) throws NotFoundException{
        ResponseEntity<FakeStoreProductDTO> productDTOResponseEntity =productCategoryService.requestForEntity(HttpMethod.GET,"https://fakestoreapi.com/products/{productId}",null ,FakeStoreProductDTO.class,productId);
        return productDTOResponseEntity.getBody();
    }
    public FakeStoreProductDTO createProduct(Product product){
        FakeStoreProductDTO fakeStoreProductDTO=new FakeStoreProductDTO();
        fakeStoreProductDTO.setTitle(product.getTitle());
        fakeStoreProductDTO.setPrice(product.getPrice());
        fakeStoreProductDTO.setImage(product.getImage());
        fakeStoreProductDTO.setDescription(product.getDescription());
        fakeStoreProductDTO.setCategory(product.getCategory().getName());
        ResponseEntity<FakeStoreProductDTO> response=productCategoryService.requestForEntity(HttpMethod.POST,"https://fakestoreapi.com/products",fakeStoreProductDTO,FakeStoreProductDTO.class,"");
        return response.getBody();
    }

    public FakeStoreProductDTO[] getAllProducts(){
        ResponseEntity<FakeStoreProductDTO[]> allProducts=productCategoryService.requestForEntity(HttpMethod.GET,"https://fakestoreapi.com/products","",FakeStoreProductDTO[].class,"");
        return allProducts.getBody();
    }

    public ResponseEntity<FakeStoreProductDTO> updateProduct(long productId,Product product){
        FakeStoreProductDTO fakeStoreProductDTO=new FakeStoreProductDTO();
        fakeStoreProductDTO.setTitle(product.getTitle());
        fakeStoreProductDTO.setPrice(product.getPrice());
        fakeStoreProductDTO.setImage(product.getImage());
        fakeStoreProductDTO.setDescription(product.getDescription());
        fakeStoreProductDTO.setCategory(product.getCategory().getName());

        return productCategoryService.patchForEntity(HttpMethod.PATCH,"https://fakestoreapi.com/products/{productId}",fakeStoreProductDTO,FakeStoreProductDTO.class,productId);
    }

    public ResponseEntity<FakeStoreProductDTO> replaceProduct(long productId,Product product){
        FakeStoreProductDTO fakeStoreProductDTO=new FakeStoreProductDTO();
        fakeStoreProductDTO.setTitle(product.getTitle());
        fakeStoreProductDTO.setPrice(product.getPrice());
        fakeStoreProductDTO.setImage(product.getImage());
        fakeStoreProductDTO.setDescription(product.getDescription());
        fakeStoreProductDTO.setCategory(product.getCategory().getName());

        return productCategoryService.requestForEntity(HttpMethod.PUT,"https://fakestoreapi.com/products/{productId}",fakeStoreProductDTO,FakeStoreProductDTO.class,productId);
    }

    public ResponseEntity<FakeStoreProductDTO> deleteProduct(long productId){
        return productCategoryService.requestForEntity(HttpMethod.DELETE,"https://fakestoreapi.com/products/{productId}","",FakeStoreProductDTO.class,productId);
    }

    public String[] getCategories(){
        ResponseEntity<String[]> categoryResponseEntity=productCategoryService.requestForEntity(HttpMethod.GET,"https://fakestoreapi.com/products/categories","", String[].class,"");
        return categoryResponseEntity.getBody();
    }
    public FakeStoreProductDTO[] getProductsOfCategory(String categoryName){
        ResponseEntity<FakeStoreProductDTO[]> response=productCategoryService.requestForEntity(HttpMethod.GET,"https://fakestoreapi.com/products/category/{categoryName}","",FakeStoreProductDTO[].class,categoryName);
        return response.getBody();
    }
}
