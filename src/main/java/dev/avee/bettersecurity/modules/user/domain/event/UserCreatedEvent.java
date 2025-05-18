package dev.avee.bettersecurity.modules.user.domain.event;

import java.util.UUID;

public record UserCreatedEvent(
    UUID id,
    String email,
    String firstName,
    String lastName
) {
}
