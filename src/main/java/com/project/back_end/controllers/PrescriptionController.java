package com.project.back_end.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionController {

    // Cambiamos el POST para que simule una validación real
    @PostMapping("/add")
    public ResponseEntity<?> save(@RequestBody Map<String, Object> prescription, 
                                  @RequestHeader("Authorization") String token) {
        
        // Aquí deberías validar el token para asegurar que solo un Doctor use la API
        if (token == null || !token.startsWith("Bearer ")) {
            return ResponseEntity.status(401).body("No autorizado");
        }

        // Simulamos que extraemos los datos del JSON enviado
        String medication = (String) prescription.get("medication");
        
        return ResponseEntity.ok("Prescripción de " + medication + " guardada exitosamente");
    }
}