package com.ayush.productservicespring.models.dtos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class FakeStoreErrorDTO {
    private String message;

    public FakeStoreErrorDTO(String message){
        this.message = message;
    }
}
