package com.baimurzin.exceptions;

public class InvalidInputException extends RuntimeException {

    public InvalidInputException() {
    }

    public InvalidInputException(String message) {
        super(message);
    }

    public InvalidInputException(String message, Throwable cause) {
        super(message, cause);
    }


}
