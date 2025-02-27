package br.com.picpayapi.controller;

import br.com.picpayapi.dto.request.TransferRequest;
import br.com.picpayapi.service.TransferService;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("transfer")
public class TransferController {

    @Inject
    TransferService service;

    @POST
    public void transfer(TransferRequest request) {
        service.transfer(request);
    }
}
