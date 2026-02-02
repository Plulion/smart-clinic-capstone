package com.project.back_end.controllers;

import com.project.back_end.models.Prescription;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionController {

    @PostMapping("/{token}") // Token como PathVariable según requerimiento
    public ResponseEntity<Map<String, String>> savePrescription(
            @PathVariable String token, 
            @RequestBody Prescription prescription) {
        
        Map<String, String> response = new HashMap<>();
        
        // Validación de token lógica para Webfinanzas
        if (token == null || token.isEmpty()) {
            response.put("error", "Invalid Token");
            return ResponseEntity.status(401).body(response);
        }

        response.put("message", "Prescription saved successfully");
        return ResponseEntity.ok(response);
    }
}