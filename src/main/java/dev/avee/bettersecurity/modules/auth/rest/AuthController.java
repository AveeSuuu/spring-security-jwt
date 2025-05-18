package dev.avee.bettersecurity.modules.auth.rest;

import dev.avee.bettersecurity.modules.auth.domain.AuthFacade;
import dev.avee.bettersecurity.modules.token.domain.response.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
class AuthController {

    private final AuthFacade authFacade;

    @PostMapping("/login")
    TokenResponse getToken() {
        return authFacade.getToken();
    }
}
