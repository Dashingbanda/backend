package com.bml.backend.repository;

import com.bml.backend.model.AvailabilitySlot;
import com.bml.backend.model.LawyerDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.OffsetDateTime;
import java.util.List;

public interface AvailabilitySlotRepository extends JpaRepository<AvailabilitySlot, Long> {
        List<AvailabilitySlot> findByLawyerAndBookedFalseAndStartTimeAfter(LawyerDto lawyerDto, OffsetDateTime after);
}
