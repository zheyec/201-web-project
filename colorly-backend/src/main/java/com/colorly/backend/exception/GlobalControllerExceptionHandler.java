package com.colorly.backend.exception;

import java.util.List;
import java.util.Map;


import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;

@ControllerAdvice
public class GlobalControllerExceptionHandler {
    @ExceptionHandler(HTTPErrorException.class)
    public ResponseEntity<Object> handleHTTPErrorException(HTTPErrorException e) {
        Map<String, String> result = Map.of("error", e.getMessage());
        return new ResponseEntity<>(result, e.getStatus());
    }

    private Map<String, String> parseMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        StringBuffer sb = new StringBuffer(); 
        List<FieldError> errors = e.getBindingResult().getFieldErrors();
        for (int i = 0; i < errors.size() - 1; i++) {
            sb.append(errors.get(i).getDefaultMessage());
            sb.append(" ");
        }
        sb.append(errors.get(errors.size() - 1).getDefaultMessage());
        return Map.of("error", sb.toString());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e) {
        return new ResponseEntity<>(parseMethodArgumentNotValidException(e), HttpStatus.BAD_REQUEST);
    }
}
