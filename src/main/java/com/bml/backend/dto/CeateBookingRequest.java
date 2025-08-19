package com.bml.backend.dto;

import jakarta.validation.constraints.*;

import java.time.OffsetDateTime;

public record CeateBookingRequest(@NotNull Long lawyerId,
                                  @NotBlank String clientName,
                                  @Email @NotBlank String clientEmail,
                                  @NotNull OffsetDateTime startTime,
                                  @NotNull OffsetDateTime endTime
) { }
