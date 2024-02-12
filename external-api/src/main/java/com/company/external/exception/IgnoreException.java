package com.company.external.exception;

public class IgnoreException extends RuntimeException {

    public IgnoreException(String message) {
        super(message);
    }
}