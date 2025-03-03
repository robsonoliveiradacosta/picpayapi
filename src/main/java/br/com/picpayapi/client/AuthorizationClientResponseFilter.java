package br.com.picpayapi.client;

import jakarta.ws.rs.client.ClientRequestContext;
import jakarta.ws.rs.client.ClientResponseContext;
import jakarta.ws.rs.client.ClientResponseFilter;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;

@Provider
public class AuthorizationClientResponseFilter implements ClientResponseFilter {

    @Override
    public void filter(ClientRequestContext clientRequestContext, ClientResponseContext clientResponseContext) {
        if (Response.Status.FORBIDDEN.getStatusCode() == clientResponseContext.getStatus()) {
            clientResponseContext.setStatusInfo(Response.Status.OK);
        }
    }
}