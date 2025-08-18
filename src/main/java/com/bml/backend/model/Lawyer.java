package com.bml.backend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Lawyer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String practiceArea; // e.g., Criminal, Civil, Corporate

    private String city;

    @Column(length = 2000)
    private String about;

    private Integer experienceYears;

    private Double hourlyRate;
}
