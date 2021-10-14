package com.senipiper.solutions.liv2train.exception;


import com.senipiper.solutions.liv2train.utils.ErrorType;

import java.util.List;

public abstract class TrainingCenterException extends RuntimeException {
    public abstract ErrorType errorType();

    private final String userMessage;
    private final List<String> errorMessages;

    public TrainingCenterException(String userMessage, List<String> errorMessages) {
        this.userMessage = userMessage;
        this.errorMessages = errorMessages;
    }

    public String getUserMessage() {
        return userMessage;
    }

    public List<String> getErrorDetails() {
        return errorMessages;
    }
}
