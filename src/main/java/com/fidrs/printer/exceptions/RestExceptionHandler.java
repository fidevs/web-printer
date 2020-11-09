package com.fidrs.printer.exceptions;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(PrinterException.class)
    public HttpEntity<Object> handlePrinterException(PrinterException e) {
        return new ResponseEntity<>(e.toResponse(), e.getStatus());
    }

}
