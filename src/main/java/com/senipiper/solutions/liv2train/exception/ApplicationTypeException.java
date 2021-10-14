package com.senipiper.solutions.liv2train.exception;

import com.senipiper.solutions.liv2train.utils.ErrorType;

import java.util.List;

public class ApplicationTypeException extends TrainingCenterException {

    public ApplicationTypeException(String userMessage, List<String> errorMessages) {
        super(userMessage, errorMessages);
    }

    @Override
    public ErrorType errorType() {
        return ErrorType.APPLICATION;
    }
}
