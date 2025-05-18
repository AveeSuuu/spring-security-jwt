package dev.avee.bettersecurity.modules.auth.domain;


import dev.avee.bettersecurity.modules.auth.domain.request.LoginRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthFacade {

    private final AuthenticateUserUseCase authenticateUserUseCase;

    public String authorizeUser(HttpServletResponse response, LoginRequest request) {
        return authenticateUserUseCase.invoke(response, request);
    }
}
