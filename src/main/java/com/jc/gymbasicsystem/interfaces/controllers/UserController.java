package com.jc.gymbasicsystem.interfaces.controllers;

import com.jc.gymbasicsystem.application.services.UserService;
import com.jc.gymbasicsystem.domain.entities.UserEntity;
import com.jc.gymbasicsystem.application.dto.CreateUserDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("create")
    public ResponseEntity<UserEntity> createUser(@Valid @RequestBody CreateUserDto createUserDto) {
        System.out.println("UserController.createUser" + createUserDto);
        return ResponseEntity.ok(userService.createUser(createUserDto));
    }

}
