package com.project.back_end.repo;

import com.project.back_end.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

/**
 * Repositorio para la gestión de datos de pacientes de Webfinanzas.
 */
@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    
    // Recupera un paciente por su dirección de correo electrónico
    Optional<Patient> findByEmail(String email);

    // Permite la recuperación basada en email o número de teléfono
    Optional<Patient> findByEmailOrPhone(String email, String phone);
}