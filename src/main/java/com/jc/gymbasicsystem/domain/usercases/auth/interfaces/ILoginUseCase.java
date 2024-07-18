package com.jc.gymbasicsystem.domain.usercases.auth.interfaces;

import com.jc.gymbasicsystem.application.dto.auth.AuthenticationResponse;
import com.jc.gymbasicsystem.application.dto.auth.UserCredentialsDto;

public interface ILoginUseCase {
    AuthenticationResponse execute(UserCredentialsDto userCredentialsDto);
}
