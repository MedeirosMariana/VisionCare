package com.project.visioncare.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

public record AppointmentRecordDto(
        @NotBlank String firstName,
        @NotBlank String lastName,
                  String email,
                  String phone,
        @NotNull  UUID universityId,
                  String consultationType,
                  LocalDate datePreference,
                  LocalTime timePreference,
                  String observation,
                  LocalDateTime requestDate,
                  Boolean isConfirmed,
                  LocalDateTime confirmationDate
) {}
