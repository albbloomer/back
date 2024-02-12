package com.company.external.exception;

public class RetryException extends RuntimeException {
    public RetryException(String message) {
        super(message);
    }
}