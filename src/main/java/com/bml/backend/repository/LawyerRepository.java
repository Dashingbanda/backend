package com.bml.backend.repository;

import com.bml.backend.entity.Lawyer;
import org.springframework.data.jpa.repository.JpaRepository;
import com.bml.backend.model.LawyerDto;

import java.util.List;

public interface LawyerRepository extends JpaRepository<Lawyer, Long> {

    List<Lawyer> findByCityIgnoreCaseContainingAndPracticeAreaIgnoreCaseContaining(String city, String practiceArea);

    boolean existsByLawyerId(String lawyerId);

}
