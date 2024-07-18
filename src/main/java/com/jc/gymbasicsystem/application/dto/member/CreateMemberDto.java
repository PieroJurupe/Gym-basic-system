package com.jc.gymbasicsystem.application.dto.member;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateMemberDto {
    @NotBlank(message = "First name is mandatory")
    public String firstName;

    @NotBlank(message = "Last name is mandatory")
    public String lastName;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    public String email;

    @NotBlank(message = "Phone number is mandatory")
    public String phoneNumber;

    @NotBlank(message = "Date of birth is mandatory")
    public String dateOfBirth;

    @Min(value = 8, message = "DNI must be 8 digits")
    @NotBlank(message = "DNI is mandatory")
    public String dni;
}
