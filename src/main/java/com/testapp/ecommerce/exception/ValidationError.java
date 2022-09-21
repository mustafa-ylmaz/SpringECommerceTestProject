package com.testapp.ecommerce.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ValidationError extends ECSubError{

    private String object;
    private String field;
    private Object rejectedValue;
    private String message;



}
