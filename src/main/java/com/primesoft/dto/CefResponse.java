package com.primesoft.dto;

import org.springframework.http.HttpStatus;

import java.util.Optional;

public class CefResponse {

    private HttpStatus status;
    private Optional data;
    private String message;

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public Optional getData() {
        return data;
    }

    public void setData(Optional data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
