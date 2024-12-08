package umc.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.hospital.domain.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
