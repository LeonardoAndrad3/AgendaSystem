package ivana.charis.agenda.domain.user;

import ivana.charis.agenda.auth.GeneratedUser;
import ivana.charis.agenda.auth.User;
import ivana.charis.agenda.domain.client.Client;
import ivana.charis.agenda.domain.employee.Employee;
import ivana.charis.agenda.domain.employee.Work;
import jakarta.persistence.Entity;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserLogin implements UserDetails, GeneratedUser{

    private Long id;
    private String name;
    private String email;
    private String password;
    private Work work;
    private String role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_"+role));
    }
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public User generatedUser() {
        var authorities = getAuthorities().stream().findFirst().map(GrantedAuthority::getAuthority).orElse(null);
        return new User(id, name, email, work, authorities);
    }
    @Override
    public UserLogin generatedUserLogin() {
        return null;
    }
}
