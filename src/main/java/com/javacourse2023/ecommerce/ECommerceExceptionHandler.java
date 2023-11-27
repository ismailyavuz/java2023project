package com.javacourse2023.ecommerce;

import com.javacourse2023.ecommerce.exception.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ECommerceExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = RuntimeException.class)
    public ErrorMessage badRequest(RuntimeException e){
        return new ErrorMessage(e.getMessage());
    }

}
