package com.example.vaccination.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({IllegalArgumentException.class})
    public ResponseEntity<String> handleValidationException(IllegalArgumentException ex,HttpServletRequest request) {
        return this.buildResponse(ex,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<String> handleNoDataFoundException(EntityNotFoundException ex, HttpServletRequest request) {
        return this.buildResponse(ex,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<String> handleAll(Exception ex, HttpServletRequest request) {
        return this.buildResponse(ex,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({CrewPayException.class})
    public ResponseEntity<String> handleCrewPayAll(CrewPayException ex, HttpServletRequest request) {
        return this.buildResponse(ex,HttpStatus.NOT_FOUND);
    }
    private ResponseEntity<String> buildResponse(Exception ex, HttpStatus httpStatus){
        log.error(ex.getMessage());
        return new ResponseEntity<>(ex.getMessage(),httpStatus);
    }

}