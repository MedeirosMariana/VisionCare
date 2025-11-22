package com.project.visioncare.dtos;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record CartItemRecordDto(
        @NotNull UUID productId,
        @NotNull UUID cartId,
        @NotNull Integer quantity
) {}
