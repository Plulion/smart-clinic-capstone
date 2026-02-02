package com.project.back_end.controllers;

import com.project.back_end.models.Doctor;
import com.project.back_end.repo.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;

    @PostMapping("/add")
    public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor) {
        return ResponseEntity.ok(doctorRepository.save(doctor));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Doctor>> getAll() {
        return ResponseEntity.ok(doctorRepository.findAll()); // Usado para el listado
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Doctor> updateDoctor(@PathVariable Long id, @RequestBody Doctor details) {
        Doctor doc = doctorRepository.findById(id).orElseThrow();
        doc.setName(details.getName());
        doc.setSpecialty(details.getSpecialty());
        return ResponseEntity.ok(doctorRepository.save(doc));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable Long id) {
        doctorRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}