package com.bml.backend.model;

import java.time.LocalDate;

import com.bml.backend.entity.Lawyer;
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

    @ManyToOne
    @JoinColumn(name = "lawyerId", nullable = false)
    private Lawyer lawyer;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @Email
    @NotBlank
    private String clientEmail;

    @Column(nullable = false)
    private LocalDate date;

    // 🔹 Booking status (e.g., PENDING, CONFIRMED, CANCELED)
    @Column(nullable = false)
    private String status;
}
