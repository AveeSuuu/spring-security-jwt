package dev.avee.bettersecurity.modules.user.domain;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class GetUserByEmailUseCase {

    private final UserRepository repository;

    public User invoke(String email) {
        return repository.findByEmail(email).orElse(null);
    }
}
