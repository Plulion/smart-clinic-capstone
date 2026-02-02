package com.project.back_end.controllers;

import com.project.back_end.models.Appointment;
import com.project.back_end.repo.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @PostMapping("/add")
    public ResponseEntity<Appointment> add(@RequestBody Appointment appointment) {
        return ResponseEntity.ok(appointmentRepository.save(appointment));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Appointment>> getAll() {
        return ResponseEntity.ok(appointmentRepository.findAll());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Appointment> update(@PathVariable Long id, @RequestBody Appointment details) {
        Appointment app = appointmentRepository.findById(id).orElseThrow();
        app.setAppointmentTime(details.getAppointmentTime());
        app.setDoctor(details.getDoctor());
        app.setPatient(details.getPatient());
        return ResponseEntity.ok(appointmentRepository.save(app));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        appointmentRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}