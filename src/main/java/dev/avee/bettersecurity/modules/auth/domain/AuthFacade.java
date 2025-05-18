package dev.avee.bettersecurity.modules.auth.domain;


import dev.avee.bettersecurity.modules.token.domain.TokenFacade;
import dev.avee.bettersecurity.modules.token.domain.response.TokenResponse;
import java.util.UUID;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AuthFacade {

    private final TokenFacade tokenFacade;

    public TokenResponse getToken() {
        return new TokenResponse(tokenFacade.createAccessToken(UUID.randomUUID()));
    }
}
