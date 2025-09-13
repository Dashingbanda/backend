package com.bml.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Lawyer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "lawyerId" , nullable = false, unique = true, updatable = false)
    private String lawyerId;

    @Column(name = "fullName" ,nullable = false)
    private String fullName;

    @Column(name = "practiceArea" ,nullable = false)
    private String practiceArea; // e.g., Criminal, Civil, Corporate

    @Column(name = "city" ,nullable = false)
    private String city;

    @Column(name = "about" ,length = 2000)
    private String about;

    @Column(name = "experienceYears" ,nullable = false)
    private Integer experienceYears;

    @Column(name = "hourlyRate" ,nullable = false)
    private Double hourlyRate;
}
