package dev.avee.bettersecurity.modules.user.domain;

import dev.avee.bettersecurity.modules.user.domain.event.UserCreatedEvent;
import java.util.UUID;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class User {

    private UUID id;
    private String email;
    private String firstName;
    private String lastName;

    static UserCreatedEvent create(String email, String firstName, String lastName) {
        return new UserCreatedEvent(UUID.randomUUID(), email, firstName, lastName);
    }
}
