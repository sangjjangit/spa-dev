package com.demo.common.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Value;

@Getter
@Builder
public class CommonResponse {
    private String code;
    private Object result;
    private String message;
}
