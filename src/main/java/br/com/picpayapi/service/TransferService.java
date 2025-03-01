package br.com.picpayapi.service;

import br.com.picpayapi.dto.request.TransferRequest;
import br.com.picpayapi.dto.response.TransactionResponse;
import br.com.picpayapi.repository.TransactionRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.jboss.logging.Logger;

import java.util.List;

@ApplicationScoped
public class TransferService {

    @Inject
    Logger logger;

    @Inject
    TransactionRepository repository;

    public void transfer(TransferRequest request) {
        logger.infof("[Transfer] value: %s, payer: %s, payee: %s",
                request.value(), request.payer(), request.payee());
    }

    public List<TransactionResponse> findAll() {
        return repository.listAll().stream().map(TransactionResponse::new).toList();
    }
}
