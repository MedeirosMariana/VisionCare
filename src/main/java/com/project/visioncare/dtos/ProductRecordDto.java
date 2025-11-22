package com.project.visioncare.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductRecordDto(
        @NotBlank String description,
        @NotNull  Integer type,
                  String image,
        @NotNull  Integer quantity,
        @NotNull  BigDecimal value,
                  BigDecimal discountValue,
                  BigDecimal discountPercentage,
                  Integer reviewsQuantity,
                  BigDecimal reviewsRatingStars
) {}
