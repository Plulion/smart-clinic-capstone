package com.project.back_end.controllers;

import com.project.back_end.models.Patient;
import com.project.back_end.repo.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @PostMapping("/add")
    public ResponseEntity<Patient> addPatient(@RequestBody Patient patient) {
        return ResponseEntity.ok(patientRepository.save(patient));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Patient>> getAll() {
        return ResponseEntity.ok(patientRepository.findAll());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Long id, @RequestBody Patient details) {
        Patient pat = patientRepository.findById(id).orElseThrow();
        pat.setName(details.getName());
        pat.setEmail(details.getEmail());
        pat.setPhone(details.getPhone());
        return ResponseEntity.ok(patientRepository.save(pat));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
        patientRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}