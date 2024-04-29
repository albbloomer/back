package com.company.store.exception;

import com.company.store.common.ErrorResponseDto;
import com.company.store.common.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {

    private final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public ErrorResponseDto handleIllegalArgumentException(final IllegalArgumentException e) {
        log.error("[{}]", e.getMessage(), e);
        return ErrorResponseDto.of(HttpStatus.BAD_REQUEST, e.getMessage());
    }

    /**
     * @ResponseStatus 가 존재하지 않으면 상태코드가 200 으로 나감
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(BusinessException.class)
    public ErrorResponseDto handleBusinessException(final BusinessException e) {
        log.error("[{}]", e.getMessage(), e);
        return ErrorResponseDto.of(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
    }
}