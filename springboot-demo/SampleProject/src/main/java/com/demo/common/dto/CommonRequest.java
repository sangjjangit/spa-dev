package com.demo.common.dto;

import lombok.Getter;

@Getter
public class CommonRequest<T> {
    private T data;
}
