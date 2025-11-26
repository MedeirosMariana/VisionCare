package com.project.visioncare.dtos;

import java.math.BigDecimal;
import java.util.UUID;

public record UniversityResponseDto(
        UUID id,
        String description,
        String acronym,
        String image,
        Integer totalStudents,
        String city,
        Boolean activePartnership,
        BigDecimal discountPercent,
        BigDecimal rating,
        String color,
        String logo
) {}
