package br.com.picpayapi.dto.response;

public record AuthorizationResponse(String status, Data data) {
    public record Data(boolean authorization) {
    }
}
