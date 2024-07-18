package com.jc.gymbasicsystem.application.dto.promotion;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreatePromotionDto {
    @NotBlank(message = "Name is mandatory")
    public String name;

    @NotBlank(message = "Description is mandatory")
    public String description;

    @NotNull(message = "Discount is mandatory")
    public float discount;

    @NotNull(message = "Start date is mandatory")
    public String startDate;

    @NotNull(message = "End date is mandatory")
    public String endDate;
}
