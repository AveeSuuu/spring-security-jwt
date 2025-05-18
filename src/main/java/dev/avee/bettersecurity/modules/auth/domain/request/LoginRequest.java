package dev.avee.bettersecurity.modules.auth.domain.request;

public record LoginRequest(
    String email,
    String password
) {
}
