package com.bml.backend.model;

import java.time.OffsetDateTime;
import jakarta.validation.constraints.*;
import lombok.*;

import jakarta.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Lawyer lawyer;

    @NotBlank
    private String clientName;

    @Email
    @NotBlank
    private String clientEmail;

    @Column(nullable = false)
    private OffsetDateTime startTime;

    @Column(nullable = false)
    private OffsetDateTime endTime;

}
