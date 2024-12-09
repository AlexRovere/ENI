package com.example.ludotheque.Exception;

public class EmailAlreadyTakenException extends Exception{
    public EmailAlreadyTakenException(String message) {
        super(message);
    }

    public EmailAlreadyTakenException(String message, Throwable cause) {
        super(message, cause);
    }
}
