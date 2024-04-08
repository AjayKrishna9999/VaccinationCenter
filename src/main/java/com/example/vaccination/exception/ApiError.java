package com.example.vaccination.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiError implements Serializable {
    private static final long serialVersionUID = -6071800443118762777L;

    private HttpStatus status;
    //private ApiErrorCode errorCode;
    private int errorCode;
    private String message;
    private String servletPath;


}
