package com.belyuk.shop.exception;

public class PoolInitializationException extends Exception{
    public PoolInitializationException() {
    }

    public PoolInitializationException(String message) {
        super(message);
    }

    public PoolInitializationException(String message, Throwable cause) {
        super(message, cause);
    }

    public PoolInitializationException(Throwable cause) {
        super(cause);
    }
}
