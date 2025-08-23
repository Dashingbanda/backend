package com.bml.backend.controller;

import com.bml.backend.model.Lawyer;
import com.bml.backend.service.LawyerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lawyers")
@CrossOrigin(origins = "*")
public class LawyerController {

    private final LawyerService lawyerService;

    public LawyerController(LawyerService lawyerService) {
        this.lawyerService = lawyerService;
    }

    @GetMapping
    public ResponseEntity<List<Lawyer>> getAllLawyers() {
        return ResponseEntity.ok(lawyerService.getAllLawyers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lawyer> getLawyerById(@PathVariable Long id) {
        return ResponseEntity.ok(lawyerService.getLawyerById(id));
    }

    @PostMapping
    public ResponseEntity<Lawyer> createLawyer(@RequestBody Lawyer lawyer) {
        return ResponseEntity.ok(lawyerService.createLawyer(lawyer));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lawyer> updateLawyer(@PathVariable Long id, @RequestBody Lawyer lawyer) {
        return ResponseEntity.ok(lawyerService.updateLawyer(id, lawyer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLawyer(@PathVariable Long id) {
        lawyerService.deleteLawyer(id);
        return ResponseEntity.noContent().build();
    }
}
