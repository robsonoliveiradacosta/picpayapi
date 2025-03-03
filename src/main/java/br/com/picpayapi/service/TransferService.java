package br.com.picpayapi.service;

import br.com.picpayapi.dto.request.TransferRequest;
import br.com.picpayapi.dto.response.TransactionResponse;
import br.com.picpayapi.exception.InvalidTransactionException;
import br.com.picpayapi.model.Transaction;
import br.com.picpayapi.repository.TransactionRepository;
import br.com.picpayapi.repository.WalletRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.core.Response;
import org.jboss.logging.Logger;

import java.util.List;

@ApplicationScoped
public class TransferService {

    @Inject
    Logger logger;

    @Inject
    WalletRepository walletRepository;

    @Inject
    TransactionRepository transactionRepository;

    @Transactional
    public void transfer(TransferRequest request) {
        var payer = walletRepository.findByIdOptional(request.payer())
                .orElseThrow(() -> new NotFoundException("payer not found"));
        var payee = walletRepository.findByIdOptional(request.payee())
                .orElseThrow(() -> new NotFoundException("payee not found"));
        if (payer.isShopkeeper()) {
            throw new InvalidTransactionException(Response.Status.BAD_REQUEST, "Shopkeeper cannot make transfer");
        }
        if (payer.getBalance().compareTo(request.value()) < 0) {
            throw new InvalidTransactionException(Response.Status.BAD_REQUEST, "Insufficient balance");
        }
        var transaction = new Transaction();
        transaction.setPayer(payer);
        transaction.setPayee(payee);
        transaction.setAmount(request.value());
        payer.debit(request.value());
        payee.credit(request.value());

        transactionRepository.persist(transaction);
        walletRepository.persist(payer);
        walletRepository.persist(payee);

        logger.infof("[Transfer] amount: %s, payer: %s, payee: %s",
                request.value(), request.payer(), request.payee());
    }

    public List<TransactionResponse> findAll() {
        return transactionRepository.listAll().stream().map(TransactionResponse::new).toList();
    }
}
