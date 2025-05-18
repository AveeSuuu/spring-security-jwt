package dev.avee.bettersecurity.modules.usercredentials.infrastructure;

import dev.avee.bettersecurity.modules.usercredentials.domain.UserCredentialsFacade;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
class UserCredentialsConfig {

    @Bean
    UserCredentialsFacade userCredentialsFacade(PasswordEncoder passwordEncoder) {
        return new UserCredentialsFacade(new InMemoryUserCredentialsRepository(), passwordEncoder);
    }
}
