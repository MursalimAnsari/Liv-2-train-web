package com.senipiper.solutions.liv2train.exception;

import com.senipiper.solutions.liv2train.utils.ErrorType;

import java.util.Collections;

public class ServerTypeException extends TrainingCenterException {

    public ServerTypeException(String userMessage) {
        super(userMessage, Collections.emptyList());
    }

    @Override
    public ErrorType errorType() {
        return ErrorType.SERVER;
    }
}
