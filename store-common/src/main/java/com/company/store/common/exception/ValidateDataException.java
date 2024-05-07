package com.company.store.common.exception;

/**
 * RunTimeException 이 아닌 그것을 상속한 IllegalArgumentException 를 함으로써 장점은
 * '코드가 주는 명확함'
 */
public class ValidateDataException extends IllegalArgumentException {

    public ValidateDataException(final String exceptionMessage) {
        super(exceptionMessage);
    }

}
