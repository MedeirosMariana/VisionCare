package com.project.visioncare.dtos;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

public record AppointmentRecordDto(
          @NotBlank String firstName,
          @NotBlank String lastName,
          @NotBlank String email,
          @NotBlank String phone,
          @NotBlank UUID universityId,
          @NotBlank String consultationType,
                   LocalDate datePreference,
                   LocalTime timePreference,
                   String observation,
                   LocalDateTime requestDate,
                   Boolean isConfirmed,
                   LocalDateTime confirmationDate
) {}
