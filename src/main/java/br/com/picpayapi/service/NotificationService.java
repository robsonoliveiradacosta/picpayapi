package br.com.picpayapi.service;

import br.com.picpayapi.client.NotificationClient;
import io.quarkus.vertx.ConsumeEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;
import org.jboss.resteasy.reactive.ClientWebApplicationException;
import org.jboss.resteasy.reactive.RestResponse;

@ApplicationScoped
public class NotificationService {

    @Inject
    Logger logger;

    @RestClient
    NotificationClient notificationClient;

    @ConsumeEvent(value = "transaction-notification", blocking = true)
    public void notify(String fullName) {
        try {
            try (var response = notificationClient.sendNotification()) {
                if (response.getStatus() == RestResponse.Status.NO_CONTENT.getStatusCode()) {
                    logger.infof("notification sent to %s", fullName);
                }
            }
        } catch (ClientWebApplicationException e) {
            if (e.getResponse().getStatus() == RestResponse.Status.GATEWAY_TIMEOUT.getStatusCode()) {
                logger.infof("failed to send notification to %s", fullName);
            }
        }
    }
}
