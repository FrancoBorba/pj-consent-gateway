package com.Gateway.PJ.exceptions.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.Gateway.PJ.dto.ApiErrorDTO;
import com.Gateway.PJ.exceptions.ResourceNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiErrorDTO> handleResourceNotFound(ResourceNotFoundException ex, WebRequest request) {
        

        ApiErrorDTO errorDetails = new ApiErrorDTO(
            HttpStatus.NOT_FOUND.value(),  
            "Not Found",                   
            ex.getMessage(),               
            request.getDescription(false).replace("uri=", "") 
        );

        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
}
