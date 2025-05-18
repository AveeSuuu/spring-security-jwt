package dev.avee.bettersecurity.modules.usercredentials.infrastructure;

import dev.avee.bettersecurity.modules.usercredentials.domain.UserCredentials;
import dev.avee.bettersecurity.modules.usercredentials.domain.UserCredentialsRepository;
import dev.avee.bettersecurity.modules.usercredentials.domain.event.UserCredentialsCreatedEvent;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Repository;

@Repository
class InMemoryUserCredentialsRepository implements UserCredentialsRepository {

    private final Map<UUID, UserCredentials> userCredentials;

    public InMemoryUserCredentialsRepository() {
        this.userCredentials = new ConcurrentHashMap<>();
        var id = UUID.randomUUID();
        var userId = UUID.fromString("57fb058f-dcf9-4a38-b1cc-888a8cacf8b8");
        this.userCredentials.put(
            id, UserCredentials.builder()
                .id(id)
                .userId(userId)
                .password("$2a$12$ASN7DNld10gIfay.jPn7KeUif6cdqkCwq1DGXFJOx606bkdjEpRf.")
                .build()
        );
    }

    @Override
    public Optional<UserCredentials> findByUserId(UUID userId) {
        return userCredentials.values().stream()
            .filter(uc -> uc.getUserId().equals(userId))
            .findFirst();
    }

    @Override
    public void apply(UserCredentialsCreatedEvent event) {
        var credentials = UserCredentials.builder()
            .id(event.id())
            .userId(event.userId())
            .password(event.password())
            .build();
        userCredentials.put(event.id(), credentials);
    }
}
