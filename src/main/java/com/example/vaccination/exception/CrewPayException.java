package com.example.vaccination.exception;

public class CrewPayException extends RuntimeException {



    private static final long serialVersionUID = 1L;

    private String errorCode;

    public CrewPayException(String message) {
        super(message);
        //this.errorCode=errorCode;
    }

    public CrewPayException(String errorCode,String message) {
        super(message);
        this.errorCode=errorCode;
    }

    public CrewPayException(String errorCode, String message, Throwable throwable) {
        super(message, throwable);
        this.errorCode=errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
