package umc.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.hospital.domain.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
