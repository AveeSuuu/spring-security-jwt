package dev.avee.bettersecurity.modules.usercredentials.domain;

import dev.avee.bettersecurity.modules.usercredentials.domain.event.UserCredentialsCreatedEvent;
import java.util.UUID;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserCredentials {

    private UUID id;
    private UUID userId;
    private String password;

    static UserCredentialsCreatedEvent create(UUID userId, String password) {
        return new UserCredentialsCreatedEvent(UUID.randomUUID(), userId, password);
    }
}
