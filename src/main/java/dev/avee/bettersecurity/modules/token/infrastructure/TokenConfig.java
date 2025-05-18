package dev.avee.bettersecurity.modules.token.infrastructure;

import dev.avee.bettersecurity.common.properties.JwtProperties;
import dev.avee.bettersecurity.modules.token.domain.TokenFacade;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.jwt.JwtEncoder;

@Configuration
class TokenConfig {

    @Bean
    TokenFacade tokenFacade(JwtProperties jwtProperties, JwtEncoder jwtEncoder) {
        return new TokenFacade(jwtProperties, jwtEncoder);
    }
}
