package com.infinitychances.inflib.exceptions;

public class InvalidInputException extends RuntimeException {
    @java.io.Serial
    static final long serialVersionUID = 2L;

    public InvalidInputException(String message) {
        super("Invalid Input: " + message);
    }

    public InvalidInputException(String message, String cause) {
        super("Invalid Input: " + message + cause);
    }
}
