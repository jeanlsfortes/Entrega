package com.solivros.solivros.exceptionhandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExeptionHandler extends ResponseEntityExceptionHandler{
    
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<Erro.Campo> campos = new ArrayList<>();
    
        //for ()

        Erro erro = new Erro();
        erro.setStatus(status.value());
        erro.setDataHora(LocalDateTime.now());
        erro.setTitulo("um ou mais campo invalido");
        return handleExceptionInternal(ex, erro, headers, status, request);
    }
}
