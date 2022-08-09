package org.aibles.worker2.exeption;

public class BadRequestException extends RuntimeException{
    private final String message;

    public BadRequestException(String message) {
        super();
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
