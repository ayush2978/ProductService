package com.ayush.productservicespring.client.fakestoreclient;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductCategoryServiceImpl {
    private RestTemplate restTemplate;
    ProductCategoryServiceImpl(RestTemplate restTemplate){
        this.restTemplate=restTemplate;
    }

    public <T> ResponseEntity<T> requestForEntity(HttpMethod httpMethod, String url, @Nullable Object request, Class<T> responseType, Object uriVariables) throws RestClientException {
        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
        return restTemplate.execute(url, httpMethod, requestCallback, responseExtractor, uriVariables);
    }

    /**
     * HttpClient in java does not directly support the patch request. So we need to use the RestTemplateBuilder to build a RestTemplate with HttpComponentsClientHttpRequestFactory as the request factory.
     * @param httpMethod
     * @param url
     * @param request
     * @param responseType
     * @param uriVariables
     * @return
     * @param <T>
     * @throws RestClientException
     */
    public <T> ResponseEntity<T> patchForEntity(HttpMethod httpMethod,String url, @Nullable Object request, Class<T> responseType, Object uriVariables) throws RestClientException {
        RestTemplate restTemplate1= new RestTemplateBuilder().requestFactory(HttpComponentsClientHttpRequestFactory.class).build();
        RequestCallback requestCallback = restTemplate1.httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate1.responseEntityExtractor(responseType);
        return restTemplate1.execute(url, httpMethod, requestCallback, responseExtractor, uriVariables);
    }
}
