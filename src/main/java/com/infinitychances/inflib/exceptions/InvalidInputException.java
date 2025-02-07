package com.infinitychances.inflib.exceptions;

public class InvalidInputException extends RuntimeException {
    @java.io.Serial
    private static final long serialVersionUID = 8997314L;

    public InvalidInputException(String message) {
        super("Invalid Input: " + message);
    }
    //Just extra thing to it
    public InvalidInputException(String message, String cause) {
        super("Invalid Input: " + message + "\nCaused By: " + cause);
    }
}
