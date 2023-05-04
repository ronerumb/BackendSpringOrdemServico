package com.os.os.Exceptions;

public class DataIntegratyViolationException extends RuntimeException{
    public DataIntegratyViolationException(String message) {
        super(message);
    }

    public DataIntegratyViolationException(String message, Throwable cause) {
        super(message, cause);
    }
}
