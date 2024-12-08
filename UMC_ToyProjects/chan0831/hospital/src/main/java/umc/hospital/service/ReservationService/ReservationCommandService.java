package umc.hospital.service.ReservationService;

import umc.hospital.domain.Reservation;
import umc.hospital.web.dto.ReservationRequestDTO;
import umc.hospital.web.dto.ReservationResponseDTO;

public interface ReservationCommandService {
    Reservation createReservation(ReservationRequestDTO.createReservationDTO request);
}
