package dev.avee.bettersecurity.modules.auth.domain;

public interface PrincipalService {

    PrincipalImpl getPrincipal();
    void setAuthentication(PrincipalImpl principal);
}
