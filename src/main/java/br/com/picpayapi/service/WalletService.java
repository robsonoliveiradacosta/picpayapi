package br.com.picpayapi.service;

import br.com.picpayapi.dto.request.WalletRequest;
import br.com.picpayapi.dto.response.WalletResponse;
import br.com.picpayapi.repository.WalletRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class WalletService {

    @Inject
    WalletRepository repository;

    public List<WalletResponse> findAll() {
        return repository.listAll().stream().map(WalletResponse::new).toList();
    }

    @Transactional
    public WalletResponse create(WalletRequest request) {
        request.validate();
        if (repository.existsByEmail(request.email())) {
            throw new IllegalArgumentException("email already exists");
        }
        var wallet = request.toModel();
        if (wallet.isShopkeeper()) {
            if (repository.existsByCnpj(request.cnpj())) {
                throw new IllegalArgumentException("cnpj already exists");
            }
        } else if (repository.existsByCpf(request.cpf())) {
            throw new IllegalArgumentException("cpf already exists");
        }
        repository.persist(wallet);
        return new WalletResponse(wallet);
    }
}
