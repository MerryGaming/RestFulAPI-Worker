package org.aibles.worker2.exeption;

public class InternalServerException extends RuntimeException {
    private final String message;

    public InternalServerException(String message) {
        super();
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

}
