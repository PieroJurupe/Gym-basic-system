package com.jc.gymbasicsystem.domain.usercases.user;

import com.jc.gymbasicsystem.application.dto.CreateUserDto;
import com.jc.gymbasicsystem.domain.entities.UserEntity;
import com.jc.gymbasicsystem.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CreateUserUseCase {

    @Autowired
    private final UserRepository userRepository;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    public CreateUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity execute(CreateUserDto createUserDto) {

        UserEntity createUser = new UserEntity();

//        String passwordHash = passwordEncoder.encode(createUserDto.getPassword());

        createUser.setUsername(createUserDto.getUsername());
//        createUser.setPassword(passwordHash);
//        createUser.setRole(createUserDto.getRole());
        createUser.setActive(true);
        userRepository.save(createUser);

        return createUser;
    }
}
