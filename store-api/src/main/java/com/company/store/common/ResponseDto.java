package com.company.store.common;

public record ResponseDto<T>(String message, T data) {

    private static final String SUCCESS = "The request was successful.";

    public static <T> ResponseDto<T> ok(final T data) {
        return new ResponseDto<>(SUCCESS, data);
    }

    public static <T> ResponseDto<T> ok() {
        return new ResponseDto<>(SUCCESS, null);
    }
}