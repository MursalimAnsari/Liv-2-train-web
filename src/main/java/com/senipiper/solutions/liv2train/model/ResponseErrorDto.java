package com.senipiper.solutions.liv2train.model;

import com.senipiper.solutions.liv2train.utils.ErrorType;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ResponseErrorDto {
    private Integer code;
    private ErrorType errorType;
    private String userMessage;
    private List<String> errorMessages;
}
