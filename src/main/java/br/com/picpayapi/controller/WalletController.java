package br.com.picpayapi.controller;

import br.com.picpayapi.dto.request.WalletRequest;
import br.com.picpayapi.dto.response.WalletResponse;
import br.com.picpayapi.service.WalletService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

import java.util.List;

@Path("wallets")
public class WalletController {

    @Inject
    WalletService service;

    @GET
    public List<WalletResponse> findAll() {
        return service.findAll();
    }

    @POST
    public WalletResponse create(@Valid WalletRequest request) {
        return service.create(request);
    }
}
