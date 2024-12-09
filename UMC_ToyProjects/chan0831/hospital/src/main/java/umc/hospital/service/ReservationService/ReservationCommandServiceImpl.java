package umc.hospital.service.ReservationService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.hospital.apiPayload.code.status.ErrorStatus;
import umc.hospital.apiPayload.exception.GeneralException;
import umc.hospital.converter.ReservationConverter;
import umc.hospital.domain.Doctor;
import umc.hospital.domain.Patient;
import umc.hospital.domain.Reservation;
import umc.hospital.domain.enums.RStatus;
import umc.hospital.repository.DoctorRepository;
import umc.hospital.repository.PatientRepository;
import umc.hospital.repository.ReservationRepository;
import umc.hospital.web.dto.ReservationRequestDTO;
import umc.hospital.web.dto.ReservationResponseDTO;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ReservationCommandServiceImpl implements ReservationCommandService{

    private final ReservationRepository reservationRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    @Override
    public Reservation createReservation(ReservationRequestDTO.createReservationDTO request) {

        Patient patient = patientRepository.findById(request.getPatientId())
                .orElseThrow(()-> new GeneralException(ErrorStatus.PATIENT_NOT_FOUND));

        Doctor doctor = doctorRepository.findById(request.getDoctorId())
                .orElseThrow(()->new GeneralException(ErrorStatus.DOCTOR_NOT_FOUND) );

        Reservation reservation = ReservationConverter.toReservation(request, patient, doctor);

        return reservationRepository.save(reservation);
    }

    @Override
    public List<ReservationResponseDTO.ReservationResultDTO> selectReservationList(ReservationRequestDTO.selectReservationDTO request) {

        Patient patient = patientRepository.findById(request.getPatientId())
                .orElseThrow(()->new GeneralException(ErrorStatus.PATIENT_NOT_FOUND));


        List<Reservation> reservationList = reservationRepository.findByPatient(patient);

        return ReservationConverter.toReservationListDTO(reservationList);
    }

    @Override
    public Reservation changeStatus(Long id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(()-> new GeneralException(ErrorStatus.RESERVATION_NOT_FOUND));

        reservation.cancel(RStatus.CANCEL);
        return reservation;
    }
}
