package dev.avee.bettersecurity.modules.auth.domain;

import dev.avee.bettersecurity.common.utils.ObjectUtils;
import dev.avee.bettersecurity.modules.auth.domain.request.LoginRequest;
import dev.avee.bettersecurity.modules.token.domain.TokenFacade;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class AuthenticateUserUseCase {

    private final AuthenticationManager authenticationManager;
    private final PrincipalService principalService;
    private final TokenFacade tokenFacade;

    String invoke(HttpServletResponse response, LoginRequest request) {
        var authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                request.email(), request.password()
            )
        );

        var principal = ObjectUtils.cast(authentication.getPrincipal(), PrincipalImpl.class);
        principalService.setAuthentication(principal);

        return tokenFacade.createAccessToken(principal.getId());
    }
}
