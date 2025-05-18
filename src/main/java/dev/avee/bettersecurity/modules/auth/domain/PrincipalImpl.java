package dev.avee.bettersecurity.modules.auth.domain;

import dev.avee.bettersecurity.modules.user.domain.User;
import dev.avee.bettersecurity.modules.usercredentials.domain.UserCredentials;
import java.security.Principal;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Getter
public class PrincipalImpl implements Principal, UserDetails {

    private UUID id;
    private String email;
    private String firstName;
    private String lastName;
    private String password;

    public PrincipalImpl(User user, UserCredentials userCredentials) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.password = userCredentials.getPassword();
    }

    @Override
    public String getName() {
        return "%s %s".formatted(this.firstName, this.lastName);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }
}
