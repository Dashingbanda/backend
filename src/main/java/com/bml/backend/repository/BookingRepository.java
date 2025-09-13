package com.bml.backend.repository;

import com.bml.backend.entity.Lawyer;
import com.bml.backend.model.Booking;
import com.bml.backend.model.Client;
import com.bml.backend.model.LawyerDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;


public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByClient(Client client);
    List<Booking> findByLawyer(Lawyer lawyer);
    boolean existsByLawyerAndDate(Lawyer lawyer, LocalDate date);

}
