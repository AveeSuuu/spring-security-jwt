package dev.avee.bettersecurity.modules.security.infrastructure;

import dev.avee.bettersecurity.common.utils.ObjectUtils;
import dev.avee.bettersecurity.modules.auth.domain.PrincipalImpl;
import dev.avee.bettersecurity.modules.security.domain.SecurityService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

class SecurityServiceImpl implements SecurityService {

    @Override
    public PrincipalImpl getPrincipal() {
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        return ObjectUtils.cast(authentication, PrincipalImpl.class);
    }

    @Override
    public void setAuthentication(PrincipalImpl authentication) {
        SecurityContextHolder.getContext().setAuthentication(
            ObjectUtils.cast(authentication, Authentication.class)
        );
    }
}