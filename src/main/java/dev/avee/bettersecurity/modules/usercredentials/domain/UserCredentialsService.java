package dev.avee.bettersecurity.modules.usercredentials.domain;

import dev.avee.bettersecurity.modules.usercredentials.domain.event.UserCredentialsCreatedEvent;
import java.util.Optional;
import java.util.UUID;

public interface UserCredentialsService {

    Optional<UserCredentials> findByUserId(UUID userId);

    void apply(UserCredentialsCreatedEvent event);
}
