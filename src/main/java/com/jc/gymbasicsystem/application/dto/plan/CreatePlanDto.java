package com.jc.gymbasicsystem.application.dto.plan;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreatePlanDto {
    @NotBlank(message = "Name is mandatory")
    public String name;

    @NotBlank(message = "Description is mandatory")
    public String description;

    @NotNull(message = "Price is mandatory")
    @Positive(message = "Price must be positive")
    public float price;

    @NotNull(message = "Duration days is mandatory")
    @Positive(message = "Duration days must be positive")
    public int durationDays;
}
