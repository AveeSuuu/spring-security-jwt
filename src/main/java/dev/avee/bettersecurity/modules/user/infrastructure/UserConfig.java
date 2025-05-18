package dev.avee.bettersecurity.modules.user.infrastructure;

import dev.avee.bettersecurity.modules.user.domain.UserFacade;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class UserConfig {

    @Bean
    UserFacade userFacade() {
        return new UserFacade(new InMemoryUserRepository());
    }
}
