package com.project.visioncare.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.List;

public record ServiceRecordDto(
        @NotBlank String title,
        @NotBlank String description,
                  String image,
        @NotNull  BigDecimal price,
        @NotNull  String duration,
                  String badge,
                  List<String> features
) {}
