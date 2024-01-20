package com.demo.shippers.core.utilities.exception;

public class BusinessException extends RuntimeException{
    public BusinessException (String message){
        super(message);
    }
}
