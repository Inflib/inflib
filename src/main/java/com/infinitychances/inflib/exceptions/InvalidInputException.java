package com.infinitychances.inflib.exceptions;

public class InvalidInputException extends RuntimeException {
    @java.io.Serial
    static final long serialVersionUID = 1L;

    public InvalidInputException(String message) {
        super("Invalid Input: " + message);
    }
}
