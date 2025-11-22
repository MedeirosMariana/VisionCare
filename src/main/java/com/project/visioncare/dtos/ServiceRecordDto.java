package com.project.visioncare.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ServiceRecordDto(
        @NotBlank String title,
                  String description,
                  String image,
        @NotNull  BigDecimal price
) {}
