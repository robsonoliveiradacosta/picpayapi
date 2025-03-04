package br.com.picpayapi.repository;

import br.com.picpayapi.model.Transaction;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class TransactionRepository implements PanacheRepository<Transaction> {

    public List<Transaction> findByWalletId(Long walletId) {
        return list("payer.id = ?1 or payee.id = ?1", walletId);
    }
}
