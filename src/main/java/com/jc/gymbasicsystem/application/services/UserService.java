package com.jc.gymbasicsystem.application.services;

import com.jc.gymbasicsystem.application.dto.CreateUserDto;
import com.jc.gymbasicsystem.application.services.interfaces.IUserService;
import com.jc.gymbasicsystem.domain.entities.UserEntity;
import com.jc.gymbasicsystem.domain.repository.UserRepository;
import com.jc.gymbasicsystem.domain.usercases.user.CreateUserUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private CreateUserUseCase createUserUseCase;

    @Autowired
    private UserRepository userRepository;

    public UserEntity createUser(CreateUserDto createUserDto) {
        return createUserUseCase.execute(createUserDto);
    }

    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) {
                return userRepository.findByUsername(username)
                        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
            }
        };
    }
}
