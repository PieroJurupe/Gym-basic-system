package com.jc.gymbasicsystem.interfaces.controllers;

import com.jc.gymbasicsystem.application.dto.CreateUserDto;
import com.jc.gymbasicsystem.application.dto.auth.AuthenticationResponse;
import com.jc.gymbasicsystem.application.dto.auth.UserCredentialsDto;
import com.jc.gymbasicsystem.application.services.AuthService;
import com.jc.gymbasicsystem.domain.entities.UserEntity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @GetMapping("/check-auth")
    public ResponseEntity<UserEntity> checkAuth() {
        return ResponseEntity.ok(authService.checkAuth());
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(
            @Valid @RequestBody UserCredentialsDto userCredentialsDto
            ) {
        AuthenticationResponse jwt = authService.login(userCredentialsDto);

        return ResponseEntity.ok(jwt);
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @Valid @RequestBody CreateUserDto createUserDto
    ) {
        AuthenticationResponse jwt = authService.register(createUserDto);

        return ResponseEntity.ok(jwt);
    }

    @DeleteMapping("/logout")
    public String logout() {
        return "logout";
    }
}
