package com.jc.gymbasicsystem.application.services.interfaces;

import com.jc.gymbasicsystem.application.dto.CreateUserDto;
import com.jc.gymbasicsystem.application.dto.auth.AuthenticationResponse;
import com.jc.gymbasicsystem.application.dto.auth.UserCredentialsDto;
import com.jc.gymbasicsystem.domain.entities.UserEntity;

public interface IAuthService {

    UserEntity checkAuth();

    AuthenticationResponse login(UserCredentialsDto userCredentialsDto);

    AuthenticationResponse register(CreateUserDto createUserDto);
}
