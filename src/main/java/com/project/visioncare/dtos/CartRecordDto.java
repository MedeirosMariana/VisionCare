package com.project.visioncare.dtos;

import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record CartRecordDto(
                  LocalDateTime createdAt,
        @NotBlank String customerName,
                  String customerPhone,
                  String universityDescription,
                  String postalCode,
                  String street,
                  String neighborhood,
                  String city,
                  String state,
                  Integer shippingType,
                  BigDecimal shippingValue,
                  String paymentTypeDesc,
                  BigDecimal paymentDiscountPct,
                  BigDecimal subtotal,
                  LocalDateTime updatedAt,
                  Boolean active
) {}
