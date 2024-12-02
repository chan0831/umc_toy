package umc.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.hospital.domain.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {
}
