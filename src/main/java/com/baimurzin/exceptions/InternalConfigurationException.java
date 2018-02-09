package com.baimurzin.exceptions;
//todo refactor
public class InternalConfigurationException extends Exception {

    public InternalConfigurationException() {
    }

    public InternalConfigurationException(String message) {
        super(message);
    }

    public InternalConfigurationException(String message, Throwable cause) {
        super(message, cause);
    }
}
