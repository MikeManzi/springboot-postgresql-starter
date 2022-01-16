package com.example.springbootstarter.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse {
    private Boolean success;
    private String message;
    private Object data;

    public ApiResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public ApiResponse(boolean success, Object data) {
        this.success = success;
        this.data = data;
    }

}