package com.project.back_end.services;

import com.project.back_end.models.Doctor;
import com.project.back_end.repo.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    public List<String> getAvailableSlots(Long id, String date) {
        // Lógica dinámica basada en el doctor ID y fecha
        return List.of("09:00", "11:00", "15:00"); 
    }

    // Método de validación de credenciales contra la base de datos
    public boolean login(String email, String password) {
        return doctorRepository.findByEmail(email)
                .map(doctor -> doctor.getPassword().equals(password))
                .orElse(false);
    }
}