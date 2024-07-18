package com.jc.gymbasicsystem.application.dto.employee;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class CreateEmployeeDto {

    @NotBlank(message = "First name is mandatory")
    @Length(min = 3, max = 20, message = "First name must be between 3 and 20 characters")
    public String firstName;

    @NotBlank(message = "Last name is mandatory")
    @Length(min = 3, max = 20, message = "Last name must be between 3 and 20 characters")
    public String lastName;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    public String email;

    @NotBlank(message = "Phone number is mandatory")
    @Length(min = 9, max = 12, message = "Phone number must be between 9 and 12 characters")
    public String phoneNumber;

    @NotBlank(message = "Address is mandatory")
    @Length(min = 3, max = 20, message = "Address must be between 3 and 20 characters")
    public String address;
}
