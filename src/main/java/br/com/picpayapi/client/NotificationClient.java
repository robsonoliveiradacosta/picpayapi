package br.com.picpayapi.client;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/v1/notify")
@RegisterRestClient(configKey = "notification-api")
public interface NotificationClient {

    @POST
    Response sendNotification();
}
