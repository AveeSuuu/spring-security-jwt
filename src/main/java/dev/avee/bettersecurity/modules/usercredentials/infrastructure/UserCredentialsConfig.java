package dev.avee.bettersecurity.modules.usercredentials.infrastructure;

import dev.avee.bettersecurity.modules.usercredentials.domain.UserCredentialsFacade;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class UserCredentialsConfig {

    @Bean
    UserCredentialsFacade userCredentialsFacade() {
        return new UserCredentialsFacade(new InMemoryUserCredentialsRepository());
    }
}
