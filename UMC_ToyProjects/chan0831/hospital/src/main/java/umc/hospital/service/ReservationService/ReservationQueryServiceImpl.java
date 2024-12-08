package umc.hospital.service.ReservationService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.hospital.apiPayload.code.status.ErrorStatus;
import umc.hospital.apiPayload.exception.GeneralException;
import umc.hospital.converter.ReservationConverter;
import umc.hospital.domain.Doctor;
import umc.hospital.domain.Patient;
import umc.hospital.domain.Reservation;
import umc.hospital.repository.DoctorRepository;
import umc.hospital.repository.PatientRepository;
import umc.hospital.repository.ReservationRepository;
import umc.hospital.web.dto.ReservationRequestDTO;
import umc.hospital.web.dto.ReservationResponseDTO;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationQueryServiceImpl implements ReservationQueryService{


}
