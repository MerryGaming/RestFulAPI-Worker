package org.aibles.worker2.exeption;

public class ServerInternalException extends RuntimeException {
    private final String message;

    public ServerInternalException(String message) {
        super();
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

}
