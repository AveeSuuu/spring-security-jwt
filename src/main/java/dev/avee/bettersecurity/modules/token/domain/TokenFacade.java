package dev.avee.bettersecurity.modules.token.domain;

import dev.avee.bettersecurity.common.properties.JwtProperties;
import java.util.UUID;
import org.springframework.security.oauth2.jwt.JwtEncoder;

public class TokenFacade {

    private final CreateAccessTokenUseCase createAccessTokenUseCase;

    public TokenFacade(JwtProperties jwtProperties, JwtEncoder jwtEncoder) {
        this.createAccessTokenUseCase = new CreateAccessTokenUseCase(jwtProperties, jwtEncoder);
    }

    public String createAccessToken(UUID userId) {
        return createAccessTokenUseCase.invoke(userId);
    }
}
