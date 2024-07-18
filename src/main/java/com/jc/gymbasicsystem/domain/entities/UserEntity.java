package com.jc.gymbasicsystem.domain.entities;

import com.jc.gymbasicsystem.domain.enums.RoleNameEnum;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "user_entity")
@EqualsAndHashCode(callSuper = true)
public class UserEntity extends BaseEntity implements UserDetails {

    @Id
    @UuidGenerator
    @Column(name = "user_id", updatable = false, nullable = false)
    public String userId;

    @Column(name = "user_name", nullable = false)
    public String username;

    @Column(name = "password", nullable = false)
    public String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    public RoleNameEnum  role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public boolean isAccountNonExpired() { return true; }

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
}
