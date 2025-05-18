package dev.avee.bettersecurity.modules.usercredentials.domain;

import java.util.UUID;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class GetUserCredentialsByUserIdUseCase {

    private final UserCredentialsRepository repository;

    public UserCredentials invoke(UUID userId) {
        return repository.findByUserId(userId).orElse(null);
    }
}
