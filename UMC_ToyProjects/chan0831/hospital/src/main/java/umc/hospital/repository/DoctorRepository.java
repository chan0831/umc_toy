package umc.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.hospital.domain.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
