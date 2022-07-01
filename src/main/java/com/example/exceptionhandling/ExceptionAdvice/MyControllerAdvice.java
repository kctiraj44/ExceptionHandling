package com.example.exceptionhandling.ExceptionAdvice;

import com.example.exceptionhandling.CustomException.EmptyInputException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.xml.ws.Response;
import java.util.NoSuchElementException;

@ControllerAdvice
public class MyControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EmptyInputException.class)
    public ResponseEntity<String> handleExp1(EmptyInputException ex,WebRequest request){
        return  new ResponseEntity<>("Input field is empty", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public  ResponseEntity<String> handleExp2(NoSuchElementException ex){
        return new ResponseEntity<>("There is Nothing present in DB",HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return new ResponseEntity<>("*----Please change Http ----*",HttpStatus.BAD_GATEWAY);
    }


    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return new ResponseEntity<>("No handle found",HttpStatus.NOT_FOUND);
    }
}
