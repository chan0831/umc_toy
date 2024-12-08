package umc.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.hospital.domain.Patient;
import umc.hospital.domain.Reservation;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> findByPatient(Patient patient);
}
