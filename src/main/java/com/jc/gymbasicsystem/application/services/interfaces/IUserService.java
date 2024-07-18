package com.jc.gymbasicsystem.application.services.interfaces;

import com.jc.gymbasicsystem.application.dto.CreateUserDto;
import com.jc.gymbasicsystem.domain.entities.UserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService {

    UserEntity createUser(CreateUserDto createUserDto);

    UserDetailsService userDetailsService();

}
