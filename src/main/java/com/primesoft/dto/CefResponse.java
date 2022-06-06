package com.primesoft.dto;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.Optional;

@Builder
@Getter
public class CefResponse {

    private HttpStatus status;
    private Optional data;
    private String message;
}
