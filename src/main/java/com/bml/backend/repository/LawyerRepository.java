package com.bml.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bml.backend.model.Lawyer;

import java.util.List;

public interface LawyerRepository extends JpaRepository<Lawyer, Long> {

    List<Lawyer> findByCityIgnoreCaseContainingAndPracticeAreaIgnoreCaseContaining(String city, String practiceArea);

}
