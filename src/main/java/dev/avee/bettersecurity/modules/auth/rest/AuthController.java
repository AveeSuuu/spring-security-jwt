package dev.avee.bettersecurity.modules.auth.rest;

import dev.avee.bettersecurity.modules.auth.domain.AuthFacade;
import dev.avee.bettersecurity.modules.auth.domain.request.LoginRequest;
import dev.avee.bettersecurity.modules.token.domain.response.TokenResponse;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
class AuthController {

    private final AuthFacade authFacade;

    @PostMapping("/login")
    TokenResponse getToken(HttpServletResponse response, @RequestBody LoginRequest loginRequest) {
        var token = authFacade.authorizeUser(response, loginRequest);
        return new TokenResponse(token);
    }
}
