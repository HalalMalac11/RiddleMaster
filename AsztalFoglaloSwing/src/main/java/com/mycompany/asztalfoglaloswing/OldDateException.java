package com.mycompany.asztalfoglaloswing;

public class OldDateException extends Exception{
    public OldDateException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return getMessage();
    }
}
