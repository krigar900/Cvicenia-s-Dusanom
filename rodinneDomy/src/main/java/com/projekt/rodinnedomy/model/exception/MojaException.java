package com.projekt.rodinnedomy.model.exception;

public class MojaException extends RuntimeException {
    public MojaException(String message) {
        super(message);
    }

    public MojaException(String message, Throwable cause) {
        super(message, cause);
    }
}
