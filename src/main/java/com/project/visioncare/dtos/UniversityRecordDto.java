package com.project.visioncare.dtos;

import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public record UniversityRecordDto(
        @NotBlank String description,
                  String image,
                  Integer studentTotal,
                  String city,
                  Boolean activePartnership,
                  BigDecimal discountPercentage
) {}
