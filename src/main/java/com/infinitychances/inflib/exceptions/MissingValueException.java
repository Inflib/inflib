package com.infinitychances.inflib.exceptions;

/**
 * Used when an instance variable was not defined, usually through a set method.
 * @author InfinityChances
 */
public class MissingValueException extends RuntimeException {
    public MissingValueException(String message) {
        super(message);
    }
}
