package dev.avee.bettersecurity.modules.user.domain;

import java.util.UUID;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class GetUserByIdUseCase {

    private final UserRepository repository;

    public User invoke(UUID id) {
        return repository.findById(id).orElse(null);
    }
}
