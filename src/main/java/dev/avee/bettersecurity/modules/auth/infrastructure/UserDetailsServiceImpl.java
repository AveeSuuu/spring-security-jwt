package dev.avee.bettersecurity.modules.auth.infrastructure;

import dev.avee.bettersecurity.modules.user.domain.UserFacade;
import dev.avee.bettersecurity.modules.usercredentials.domain.UserCredentialsFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@RequiredArgsConstructor
class UserDetailsServiceImpl implements UserDetailsService {

    private final UserFacade userFacade;
    private final UserCredentialsFacade userCredentialsFacade;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userFacade.getByEmail(username);
        var credentials = userCredentialsFacade.getByUserId(user.getId());
        return new PrincipalImpl(user, credentials);
    }
}
