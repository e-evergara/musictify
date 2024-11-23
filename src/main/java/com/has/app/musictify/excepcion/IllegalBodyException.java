package com.has.app.musictify.excepcion;

public class IllegalBodyException extends RuntimeException {
    private static final long serialVersionUID = 130714757145402552L;

    public IllegalBodyException(String message) {
        super(message);
    }
}
