package br.com.picpayapi.dto.request;

import java.math.BigDecimal;

public record TransferRequest(BigDecimal value, Long payer, Long payee) {
}
