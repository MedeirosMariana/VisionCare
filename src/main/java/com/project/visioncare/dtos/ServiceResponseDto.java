package com.project.visioncare.dtos;

import java.math.BigDecimal;
import java.util.List;

public record ServiceResponseDto(
        String title,
        String description,
        List<String> features,
        BigDecimal price,
        String duration,
        String badge,
        String image,
        String color
) {}
