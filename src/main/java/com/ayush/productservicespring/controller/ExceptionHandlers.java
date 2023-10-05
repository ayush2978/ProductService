package com.ayush.productservicespring.controller;

import com.ayush.productservicespring.exceptions.NotFoundException;
import com.ayush.productservicespring.models.dtos.FakeStoreErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler(value = {NotFoundException.class})
    public ResponseEntity<?> handleNotFoundException(NotFoundException notFoundException){
        return new ResponseEntity<>(new FakeStoreErrorDTO(notFoundException.getMessage()), HttpStatus.NOT_FOUND);
    }
}
