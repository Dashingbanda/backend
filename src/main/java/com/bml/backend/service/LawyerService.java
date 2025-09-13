package com.bml.backend.service;

import com.bml.backend.entity.Lawyer;
import com.bml.backend.repository.LawyerRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class LawyerService {
    private final LawyerRepository lawyerRepository;

    public LawyerService(LawyerRepository lawyerRepository) {
        this.lawyerRepository = lawyerRepository;
    }

    public List<Lawyer> getAllLawyers() {
        return lawyerRepository.findAll();
    }

    public Lawyer getLawyerById(Long id) {
        return lawyerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lawyer not found with id: " + id));
    }

    public Lawyer createLawyer(Lawyer lawyer) {
        String lawyerId = "lawyer" + UUID.randomUUID().toString().substring(0,8).toUpperCase();

        while(lawyerRepository.existsByLawyerId(lawyerId)) {
            lawyerId = "lawyer" + UUID.randomUUID().toString().substring(0,8).toUpperCase();
        }

        lawyer.setLawyerId(lawyerId);
        return lawyerRepository.save(lawyer);
    }

    public Lawyer updateLawyer(Long id, Lawyer lawyerDetails) {
        Lawyer lawyer = getLawyerById(id);
        lawyer.setFullName(lawyerDetails.getFullName());
        lawyer.setPracticeArea(lawyerDetails.getPracticeArea());
        lawyer.setExperienceYears(lawyerDetails.getExperienceYears());
        lawyer.setAbout(lawyerDetails.getAbout());
        lawyer.setCity(lawyerDetails.getCity());
        lawyer.setHourlyRate(lawyerDetails.getHourlyRate());
        return lawyerRepository.save(lawyer);
    }

    public void deleteLawyer(Long id) {
        Lawyer lawyer = getLawyerById(id);
        lawyerRepository.delete(lawyer);
    }
}
