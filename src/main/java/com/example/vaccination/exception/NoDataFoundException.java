package com.example.vaccination.exception;

public class NoDataFoundException extends RuntimeException{
    private static final long serialVersionUID = 0L;
    public NoDataFoundException(String message){
        super(message);
    }
}
