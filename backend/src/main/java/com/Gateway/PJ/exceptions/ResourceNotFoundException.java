package com.Gateway.PJ.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND) // status code 
public class ResourceNotFoundException extends RuntimeException{

  public ResourceNotFoundException(String message){
    super(message);
  }
}
