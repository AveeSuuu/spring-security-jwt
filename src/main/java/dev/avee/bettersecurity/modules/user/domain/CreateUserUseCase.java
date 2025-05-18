package dev.avee.bettersecurity.modules.user.domain;

import java.util.UUID;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class CreateUserUseCase {

    private final UserRepository repository;

    UUID invoke(String email, String firstName, String lastName) {
        var event = User.create(email, firstName, lastName);
        repository.apply(event);
        return event.id();
    }
}
