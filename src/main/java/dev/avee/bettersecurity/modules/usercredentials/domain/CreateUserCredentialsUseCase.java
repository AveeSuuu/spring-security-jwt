package dev.avee.bettersecurity.modules.usercredentials.domain;

import java.util.UUID;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class CreateUserCredentialsUseCase {

    private final UserCredentialsRepository repository;
    private final PasswordEncoder passwordEncoder;

    public void invoke(UUID userId, String password) {
        var event = UserCredentials.create(userId, passwordEncoder.encode(password));
        repository.apply(event);
    }
}
