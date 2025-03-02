package br.com.picpayapi.repository;

import br.com.picpayapi.model.Wallet;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class WalletRepository implements PanacheRepository<Wallet> {

    public boolean existsByEmail(String email) {
        return find("email = ?1", email).singleResultOptional().isPresent();
    }

    public boolean existsByCpf(String cpf) {
        return find("cpf = ?1", cpf).singleResultOptional().isPresent();
    }

    public boolean existsByCnpj(String cnpj) {
        return find("cnpj = ?1", cnpj).singleResultOptional().isPresent();
    }

}
