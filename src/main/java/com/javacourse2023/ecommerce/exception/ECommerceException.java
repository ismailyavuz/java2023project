package com.javacourse2023.ecommerce.exception;

import lombok.AllArgsConstructor;

public class ECommerceException extends RuntimeException {

    public ECommerceException(String message){
        super(message);
    }

}
