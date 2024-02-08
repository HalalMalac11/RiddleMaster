package com.example.foglalo;

public class InvalidTimeException extends Exception {
    public InvalidTimeException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return getMessage();
    }
}
