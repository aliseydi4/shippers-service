package com.demo.shippers.core.utilities.exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalHandlerException {
    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    private String businessException(BusinessException e){
        return e.getMessage();
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    private Map<String,String> globalHandlerException(MethodArgumentNotValidException e){
        Map<String, String> errors=new HashMap<>();
        e.getBindingResult().getAllErrors().forEach((objectError -> {
            String fieldError=((FieldError)objectError).getField();
            String errorMessage=objectError.getDefaultMessage();
            errors.put(fieldError,errorMessage);
        }));
        return errors;
    }
}
