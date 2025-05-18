package dev.avee.bettersecurity.modules.auth.infrastructure;

import dev.avee.bettersecurity.modules.user.domain.UserFacade;
import dev.avee.bettersecurity.modules.usercredentials.domain.UserCredentialsFacade;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
class AuthConfig {

    @Bean
    UserDetailsService userDetailsService(UserFacade userFacade, UserCredentialsFacade userCredentialsFacade) {
        return new UserDetailsServiceImpl(userFacade, userCredentialsFacade);
    }
}
