package dev.avee.bettersecurity.modules.user.domain;

import dev.avee.bettersecurity.modules.user.domain.event.UserCreatedEvent;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository {

    Optional<User> findById(UUID id);

    Optional<User> findByEmail(String email);

    void apply(UserCreatedEvent event);
}
