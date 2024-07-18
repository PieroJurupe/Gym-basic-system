package com.jc.gymbasicsystem.application.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class CreateUserDto {

    @NotBlank(message = "User name is mandatory")
    @Length(min = 3, max = 20, message = "User name must be between 3 and 20 characters")
    public String username;

    @NotBlank(message = "Password is mandatory")
    public String password;

    @NotBlank(message = "Role is mandatory")
    public String role;
}
