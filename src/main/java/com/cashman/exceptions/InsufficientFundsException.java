package com.cashman.exceptions;

public class InsufficientFundsException extends Exception {

    public InsufficientFundsException(String message) {
        super(message);
    }

    public InsufficientFundsException(String message, Throwable throwable) {
        super(message, throwable);
    }

}
