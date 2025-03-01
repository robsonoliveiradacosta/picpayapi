package br.com.picpayapi.exception;

import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.reactive.RestResponse;
import org.jboss.resteasy.reactive.server.ServerExceptionMapper;

public class ExceptionMappers {

    @ServerExceptionMapper
    public RestResponse<Error> mapException(NotFoundException e) {
        return RestResponse.status(Response.Status.NOT_FOUND, new Error(e.getMessage()));
    }

    @ServerExceptionMapper
    public RestResponse<Error> mapException(InvalidTransactionException e) {
        return RestResponse.status(e.getStatus(), new Error(e.getMessage()));
    }
}
