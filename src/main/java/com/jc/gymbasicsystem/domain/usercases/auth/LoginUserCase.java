package com.jc.gymbasicsystem.domain.usercases.auth;

import com.jc.gymbasicsystem.application.dto.auth.AuthenticationResponse;
import com.jc.gymbasicsystem.application.dto.auth.UserCredentialsDto;
import com.jc.gymbasicsystem.domain.entities.UserEntity;
import com.jc.gymbasicsystem.domain.repository.UserRepository;
import com.jc.gymbasicsystem.domain.usercases.auth.interfaces.ILoginUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;

@Component
public class LoginUserCase implements ILoginUseCase {

    UserRepository userRepository;

    AuthenticationManager authenticationManager;

    @Autowired
    public LoginUserCase(
            UserRepository userRepository,
            AuthenticationManager authenticationManager
    ) {
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
    }


    @Override
    public AuthenticationResponse execute(UserCredentialsDto userCredentialsDto) {

        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                userCredentialsDto.getUsername(),
                userCredentialsDto.getPassword()
        );

        authenticationManager.authenticate(authToken);

        UserEntity user = userRepository.findByUsername(userCredentialsDto.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!user.isActive())
            throw new RuntimeException("User is not active");

        String token = "s";//jwtService.generateToken(user);

        AuthenticationResponse response = new AuthenticationResponse();
        response.setAccessToken(token);

        return response;
    }
}
