package com.jc.gymbasicsystem.application.services;

import com.jc.gymbasicsystem.application.dto.CreateUserDto;
import com.jc.gymbasicsystem.application.dto.auth.AuthenticationResponse;
import com.jc.gymbasicsystem.application.dto.auth.UserCredentialsDto;
import com.jc.gymbasicsystem.application.services.interfaces.IAuthService;
import com.jc.gymbasicsystem.domain.entities.UserEntity;
import com.jc.gymbasicsystem.domain.enums.RoleNameEnum;
import com.jc.gymbasicsystem.domain.repository.UserRepository;
import com.jc.gymbasicsystem.infraestructure.interfaces.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService implements IAuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    @Override
    public UserEntity checkAuth() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            Object principal = auth.getPrincipal();
            if (principal instanceof UserDetails) {
                String username = ((UserDetails) principal).getUsername();
                return userRepository.findByUsername(username)
                        .orElseThrow(() -> new RuntimeException("User not found"));
            }
        }
        return null;
    }

    @Override
    public AuthenticationResponse login(UserCredentialsDto userCredentialsDto) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userCredentialsDto.getUsername(),
                        userCredentialsDto.getPassword()
                )
        );

        var user = userRepository.findByUsername(userCredentialsDto.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        var token = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .accessToken(token)
                .build();
    }

    @Override
    public AuthenticationResponse register(CreateUserDto createUserDto) {
        var user = User.builder()
                .username(createUserDto.getUsername())
                .password(passwordEncoder.encode(createUserDto.getPassword()))
                .roles(RoleNameEnum.USER.name())
                .build();

        UserEntity userCreate = convertUserDetailsToUser(user);

        userRepository.save(userCreate);

        var jwt = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .accessToken(jwt)
                .build();
    }
    public UserEntity convertUserDetailsToUser(UserDetails userDetails) {
        UserEntity user = new UserEntity();
        user.setUsername(userDetails.getUsername());
        user.setPassword(userDetails.getPassword());
        user.setRole(RoleNameEnum.USER);
        return user;
    }
}
