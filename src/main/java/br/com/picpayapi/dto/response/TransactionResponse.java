package br.com.picpayapi.dto.response;

import br.com.picpayapi.model.Transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransactionResponse(Long id, String payerName, String payeeName,
                                  BigDecimal amount, LocalDateTime createdAt) {

    public TransactionResponse(Transaction transaction) {
        this(transaction.getId(), transaction.getPayer().getFullName(), transaction.getPayee().getFullName(),
                transaction.getAmount(), transaction.getCreatedAt());
    }
}
