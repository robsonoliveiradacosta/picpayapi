package br.com.picpayapi.dto.response;

import br.com.picpayapi.model.Wallet;

public record WalletResponse(Long id, String fullName, String cpf, String cnpj, String email) {

    public WalletResponse(Wallet wallet) {
        this(wallet.getId(), wallet.getFullName(), wallet.getCpf(), wallet.getCnpj(), wallet.getEmail());
    }
}
