package com.project.back_end.controllers;

import com.project.back_end.models.Doctor;
import com.project.back_end.services.DoctorService; // Importar el servicio
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/doctors")
@CrossOrigin(origins = "*")
public class DoctorController {

    @Autowired
    private DoctorService doctorService; // Usar el servicio en lugar del repo directamente

    @GetMapping
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    @PostMapping
    public Doctor createDoctor(@RequestBody Doctor doctor) {
        return doctorService.saveDoctor(doctor);
    }
}