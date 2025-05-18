package dev.avee.bettersecurity.modules.usercredentials.domain.event;

import java.util.UUID;

public record UserCredentialsCreatedEvent(
    UUID id,
    UUID userId,
    String password
) {
}
