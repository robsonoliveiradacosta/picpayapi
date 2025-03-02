package br.com.picpayapi.dto.request;

import br.com.picpayapi.model.Wallet;

import java.math.BigDecimal;
import java.util.Objects;

public record WalletRequest(String fullName,
                            String cpf,
                            String cnpj,
                            String email,
                            String password,
                            BigDecimal balance) {
    public WalletRequest {
        if (Objects.isNull(cpf)) {
            cpf = "";
        }
        if (Objects.isNull(cnpj)) {
            cnpj = "";
        }
    }

    public void validate() {
        if ((cpf.isBlank() && cnpj.isBlank()) || (!cpf.isBlank() && !cnpj.isBlank())) {
            throw new IllegalArgumentException("only one CPF or CNPJ are allowed");
        }
    }

    public Wallet toModel() {
        var wallet = new Wallet();
        wallet.setFullName(fullName);
        wallet.setCpf(cpf);
        wallet.setCnpj(cnpj);
        wallet.setEmail(email);
        wallet.setPassword(password);
        wallet.setBalance(balance);
        return wallet;
    }
}
