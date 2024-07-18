package com.jc.gymbasicsystem.application.dto.auth;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class UserCredentialsDto {

    @NotBlank(message = "User name is mandatory")
    @Length(min = 3, max = 20, message = "User name must be between 3 and 20 characters")
    private String username;

    @NotBlank(message = "Password is mandatory")
    @Length(min = 3, max = 20, message = "Password must be between 3 and 20 characters")
    private String password;
}
