package com.senipiper.solutions.liv2train.exception;

import com.senipiper.solutions.liv2train.utils.ErrorType;

import java.util.Collections;

public class DBOperationException extends ApplicationTypeException {
    public DBOperationException(String userMessage) {
        super(userMessage, Collections.singletonList(userMessage));
    }
    @Override
    public ErrorType errorType() {
        return ErrorType.USER;
    }
}