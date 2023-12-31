package com.ayush.productservicespring.models.configuration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ProductConfiguration {

    @Bean(value = "restTemplate")
    public RestTemplate getRestTemplate(){
        RestTemplateBuilder restTemplateBuilder=new RestTemplateBuilder();
        return restTemplateBuilder.build();
    }
}
