package dev.avee.bettersecurity.modules.auth.domain;

import dev.avee.bettersecurity.modules.user.domain.User;
import dev.avee.bettersecurity.modules.usercredentials.domain.UserCredentials;
import java.security.Principal;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class PrincipalImpl implements Authentication, Principal, UserDetails {

    private final User user;
    private final UserCredentials credentials;

    public PrincipalImpl(User user, UserCredentials userCredentials) {
        this.user = user;
        this.credentials = userCredentials;
    }

    public UUID getId() {
        return user.getId();
    }

    @Override
    public String getName() {
        return "%s %s".formatted(this.user.getFirstName(), this.user.getLastName());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public Object getCredentials() {
        return this.credentials;
    }

    @Override
    public Object getDetails() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return this.user;
    }

    @Override
    public boolean isAuthenticated() {
        return true;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {

    }

    @Override
    public String getPassword() {
        return this.credentials.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getEmail();
    }
}
