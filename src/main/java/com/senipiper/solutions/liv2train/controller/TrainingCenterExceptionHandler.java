package com.senipiper.solutions.liv2train.controller;

import com.senipiper.solutions.liv2train.utils.ErrorType;

import com.senipiper.solutions.liv2train.exception.ServerTypeException;
import com.senipiper.solutions.liv2train.exception.TrainingCenterException;
import com.senipiper.solutions.liv2train.model.ResponseErrorDto;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpServerErrorException;

import java.util.Collections;

@RestControllerAdvice
@Slf4j
public class TrainingCenterExceptionHandler {

    static final String ERROR_MESSAGE_500 = "Internal Server Error";

    @ExceptionHandler(ServerTypeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseErrorDto handleServerTypeExceptions(TrainingCenterException e) {
        return errorResponseFrom(e, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseErrorDto handleAllOtherErrors(Exception e) {
        log.error("Error not accounted for", e);
        return ResponseErrorDto.builder()
                .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .errorType(ErrorType.SERVER)
                .userMessage(ERROR_MESSAGE_500)
                .errorMessages(Collections.singletonList(e.getMessage()))
                .build();
    }

    @ExceptionHandler(HttpServerErrorException.class)
    public ResponseEntity<ResponseErrorDto> handleHttpServerErrorException(HttpServerErrorException e) {
        ResponseErrorDto dto = ResponseErrorDto.builder()
                .code(e.getStatusCode().value())
                .errorType(ErrorType.SERVER)
                .userMessage(e.getMessage())
                .errorMessages(Collections.singletonList(e.getResponseBodyAsString()))
                .build();
        return new ResponseEntity<>(dto,e.getStatusCode());
    }


    private ResponseErrorDto errorResponseFrom(TrainingCenterException e, HttpStatus httpStatus) {
        return ResponseErrorDto.builder()
                .code(httpStatus.value())
                .errorType(e.errorType())
                .userMessage(e.getUserMessage())
                .errorMessages(e.getErrorDetails())
                .build();
    }
}
