package br.com.picpayapi.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record TransferRequest(@NotNull @Positive BigDecimal value,
                              @NotNull @Positive Long payer,
                              @NotNull @Positive Long payee) {
}
