package dev.avee.bettersecurity.modules.user.infrastructure;

import dev.avee.bettersecurity.modules.user.domain.User;
import dev.avee.bettersecurity.modules.user.domain.UserRepository;
import dev.avee.bettersecurity.modules.user.domain.event.UserCreatedEvent;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Repository;

@Repository
class InMemoryUserRepository implements UserRepository {

    private final Map<UUID, User> users = new ConcurrentHashMap<>();

    @Override
    public Optional<User> findById(UUID id) {
        return Optional.ofNullable(users.get(id));
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return users.values().stream()
            .filter(user -> user.getEmail().equals(email))
            .findFirst();
    }

    @Override
    public void apply(UserCreatedEvent event) {
        var user = User.builder()
            .id(event.id())
            .email(event.email())
            .firstName(event.firstName())
            .lastName(event.lastName())
            .build();
        users.put(event.id(), user);
    }
}
