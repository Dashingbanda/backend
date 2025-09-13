package com.bml.backend.model;

import jakarta.persistence.*;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LawyerDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, updatable = false)
    private String lawyerId;

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
