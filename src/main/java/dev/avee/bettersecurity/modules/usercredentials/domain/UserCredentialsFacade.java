package dev.avee.bettersecurity.modules.usercredentials.domain;


import java.util.UUID;

public class UserCredentialsFacade {

    private final CreateUserCredentialsUseCase createUserUseCase;
    private final GetUserCredentialsByUserIdUseCase getUserCredentialsByUserIdUseCase;

    public UserCredentialsFacade(UserCredentialsRepository userCredentialsRepository) {
        this.createUserUseCase = new CreateUserCredentialsUseCase(userCredentialsRepository);
        this.getUserCredentialsByUserIdUseCase = new GetUserCredentialsByUserIdUseCase(userCredentialsRepository);
    }

    public void createUserCredentials(UUID userId, String password) {
        createUserUseCase.invoke(userId, password);
    }

    public UserCredentials getByUserId(UUID userId) {
        return getUserCredentialsByUserIdUseCase.invoke(userId);
    }
}
