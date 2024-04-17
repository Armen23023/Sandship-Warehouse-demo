package org.example.ExeptionHandler;

public class QuantityException extends RuntimeException{

    private final String message;


    public QuantityException(final String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
