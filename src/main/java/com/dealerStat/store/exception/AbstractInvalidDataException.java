package com.dealerStat.store.exception;

public abstract class AbstractInvalidDataException extends RuntimeException {
    public AbstractInvalidDataException(String message) {
        super(message);
    }
}
