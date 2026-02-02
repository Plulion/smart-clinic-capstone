package com.project.back_end.controllers;

import com.project.back_end.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    // Endpoint corregido con PathVariables y validación de Token
    @GetMapping("/availability/{id}/{date}")
    public ResponseEntity<List<String>> getAvailability(
            @PathVariable Long id, 
            @PathVariable String date,
            @RequestHeader("Authorization") String token) {
        
        // Simulación de validación de token para Webfinanzas
        if (token == null || !token.startsWith("Bearer ")) {
            return ResponseEntity.status(401).build();
        }

        return ResponseEntity.ok(doctorService.getAvailableSlots(id, date));
    }
}