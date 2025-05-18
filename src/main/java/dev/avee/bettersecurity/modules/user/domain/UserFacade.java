package dev.avee.bettersecurity.modules.user.domain;

import java.util.UUID;

public class UserFacade {

    private final CreateUserUseCase createUserUseCase;
    private final GetUserByIdUseCase getUserByIdUseCase;
    private final GetUserByEmailUseCase getUserByEmailUseCase;

    public UserFacade(UserRepository userRepository) {
        this.createUserUseCase = new CreateUserUseCase(userRepository);
        this.getUserByIdUseCase = new GetUserByIdUseCase(userRepository);
        this.getUserByEmailUseCase = new GetUserByEmailUseCase(userRepository);
    }

    public UUID createUser(String email, String firstName, String lastName) {
        return createUserUseCase.invoke(email, firstName, lastName);
    }

    public User getById(UUID id) {
        return getUserByIdUseCase.invoke(id);
    }

    public User getByEmail(String email) {
        return getUserByEmailUseCase.invoke(email);
    }
}
