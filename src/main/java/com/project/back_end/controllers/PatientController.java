package com.project.back_end.controllers;

import com.project.back_end.models.Patient;
import com.project.back_end.repo.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/patients")
@CrossOrigin(origins = "*")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    // Esta es la ruta exacta que falló con 404 en tu consola
    @GetMapping("/all")
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    // Esta es la ruta exacta para registrar desde el formulario
    @PostMapping("/add")
    public Patient createPatient(@RequestBody Patient patient) {
        return patientRepository.save(patient);
    }

    // Agregamos eliminar por si el HTML lo requiere (como en Doctores)
    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable Long id) {
        patientRepository.deleteById(id);
    }
}