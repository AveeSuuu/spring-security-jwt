package dev.avee.bettersecurity.modules.user.domain;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class GetUserByEmailUseCase {

    private final UserRepository userRepository;

    public User invoke(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }
}
