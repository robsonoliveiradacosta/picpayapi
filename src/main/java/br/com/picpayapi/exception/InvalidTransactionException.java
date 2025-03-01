package br.com.picpayapi.exception;

import jakarta.ws.rs.core.Response;

public class InvalidTransactionException extends RuntimeException {

    private final Response.Status status;

    public InvalidTransactionException(Response.Status status, String message) {
        super(message);
        this.status = status;
    }

    public Response.Status getStatus() {
        return status;
    }
}
