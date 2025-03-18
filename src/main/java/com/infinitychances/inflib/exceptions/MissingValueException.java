package com.infinitychances.inflib.exceptions;


//thrown when a value in a class is missing
//ie. when mod id does not get defined when using the offer methods in recipe datagen
public class MissingValueException extends RuntimeException {
    public MissingValueException(String message) {
        super(message);
    }
}
