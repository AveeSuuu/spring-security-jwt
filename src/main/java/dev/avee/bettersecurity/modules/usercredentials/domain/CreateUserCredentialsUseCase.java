package dev.avee.bettersecurity.modules.usercredentials.domain;

import java.util.UUID;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class CreateUserCredentialsUseCase {

    private final UserCredentialsRepository repository;
    //TODO add password encoder once all works fine :)

    public UUID invoke(UUID userId, String password) {
        var event = UserCredentials.create(userId, password);
        repository.apply(event);
        return event.id();
    }
}
