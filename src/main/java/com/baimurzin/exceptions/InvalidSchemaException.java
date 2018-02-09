package com.baimurzin.exceptions;

public class InvalidSchemaException extends RuntimeException {

    public InvalidSchemaException() {
    }

    public InvalidSchemaException(String message) {
        super(message);
    }

    public InvalidSchemaException(String message, Throwable cause) {
        super(message, cause);
    }
}
