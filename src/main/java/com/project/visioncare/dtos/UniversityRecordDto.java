package com.project.visioncare.dtos;

import jakarta.validation.constraints.NotBlank;
import java.math.BigDecimal;

public record UniversityRecordDto(
        @NotBlank String description,
        @NotBlank String acronym,
                  String image,
                  Integer totalStudents,
                  String city,
                  Boolean activePartnership,
                  BigDecimal discountPercent,
                  BigDecimal rating
) {}
