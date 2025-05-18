package dev.avee.bettersecurity.modules.token.domain;

import dev.avee.bettersecurity.common.properties.JwtProperties;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class CreateAccessTokenUseCase {

    private final JwtProperties properties;
    private final JwtEncoder encoder;

    String invoke(UUID userId) {
        var now = Instant.now();
        var jwtClaims = JwtClaimsSet.builder()
            .issuedAt(now)
            .expiresAt(now.plus(properties.getAccessTokenTtlInMinutes(), ChronoUnit.MINUTES))
            .claim("userId", userId.toString())
            .build();
        return encoder.encode(JwtEncoderParameters.from(jwtClaims)).getTokenValue();
    }
}
