package io.github.welton.rest.controller;

import io.github.welton.exception.RegraNegocioException;
import io.github.welton.rest.ApiErrors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(RegraNegocioException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST) //codigo 400
    public ApiErrors handleRegraNegocioException(RegraNegocioException ex){
        String mensagmErro = ex.getMessage();
        return new ApiErrors(mensagmErro);
    }
}
