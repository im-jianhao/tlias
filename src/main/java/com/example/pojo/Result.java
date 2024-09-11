package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
    private boolean success;

    private String message;

    private T data;


    public static <T> Result<T> success(T data) {
        return new Result<T>(true, "success", data);
    }

    public static <T> Result<T> success() {
        return new Result<T>(true, "success", null);
    }
}
