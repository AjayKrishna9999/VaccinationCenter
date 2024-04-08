package com.example.vaccination.exception;

import java.io.FileNotFoundException;

public class ValidationException extends RuntimeException {
    private static final long serialVersionUID = 0L;
    public ValidationException(String message){
        super(message);
    }
}
