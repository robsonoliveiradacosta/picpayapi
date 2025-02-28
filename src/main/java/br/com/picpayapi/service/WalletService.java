package br.com.picpayapi.service;

import br.com.picpayapi.dto.response.WalletResponse;
import br.com.picpayapi.repository.WalletRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class WalletService {

    @Inject
    WalletRepository repository;

    public List<WalletResponse> findAll() {
        return repository.listAll().stream().map(WalletResponse::new).toList();
    }
}
