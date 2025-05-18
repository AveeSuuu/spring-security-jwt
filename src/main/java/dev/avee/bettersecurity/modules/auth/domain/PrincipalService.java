package dev.avee.bettersecurity.modules.security.domain;

import dev.avee.bettersecurity.modules.auth.domain.PrincipalImpl;

public interface SecurityService {

    PrincipalImpl getPrincipal();
    void setAuthentication(PrincipalImpl principal);
}
