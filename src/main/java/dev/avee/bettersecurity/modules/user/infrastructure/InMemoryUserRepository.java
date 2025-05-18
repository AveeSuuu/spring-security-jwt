package dev.avee.bettersecurity.modules.user.infrastructure;

import dev.avee.bettersecurity.modules.user.domain.User;
import dev.avee.bettersecurity.modules.user.domain.UserRepository;
import dev.avee.bettersecurity.modules.user.domain.event.UserCreatedEvent;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

class InMemoryUserRepository implements UserRepository {

    Map<UUID, User> users = new ConcurrentHashMap<>();

    @Override
    public Optional<User> findById(UUID id) {
        return Optional.empty();
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public void apply(UserCreatedEvent event) {

    }
}
