package br.com.picpayapi.client;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/v2/authorize")
@RegisterRestClient(configKey = "authorization-api")
@RegisterProvider(AuthorizationClientResponseFilter.class)
public interface AuthorizationClient {

    @GET
    Response verify();
}
