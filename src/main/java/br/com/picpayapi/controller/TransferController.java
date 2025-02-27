package br.com.picpayapi.controller;

import br.com.picpayapi.dto.request.TransferRequest;
import br.com.picpayapi.service.TransferService;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import org.jboss.resteasy.reactive.ResponseStatus;

@Path("transfer")
public class TransferController {

    @Inject
    TransferService service;

    @POST
    @ResponseStatus(201)
    public void transfer(TransferRequest request) {
        service.transfer(request);
    }
}
