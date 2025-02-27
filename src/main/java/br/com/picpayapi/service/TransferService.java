package br.com.picpayapi.service;

import br.com.picpayapi.dto.request.TransferRequest;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.jboss.logging.Logger;

@ApplicationScoped
public class TransferService {

    @Inject
    Logger logger;

    public void transfer(TransferRequest request) {
        logger.infof("[Transfer] value: %s, payer: %s, payee: %s",
                request.value(), request.payer(), request.payee());
    }
}
