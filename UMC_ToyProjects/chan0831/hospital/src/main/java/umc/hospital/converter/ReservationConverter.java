package umc.hospital.converter;

import umc.hospital.domain.Doctor;
import umc.hospital.domain.Hospital;
import umc.hospital.domain.Patient;
import umc.hospital.domain.Reservation;
import umc.hospital.web.dto.ReservationRequestDTO;
import umc.hospital.web.dto.ReservationResponseDTO;

public class ReservationConverter {

    public static ReservationResponseDTO.ReservationResultDTO toReservationResult(Reservation reservation){

        return ReservationResponseDTO.ReservationResultDTO.builder()
                .patientName(reservation.getPatient().getName())
                .doctorName(reservation.getDoctor().getName())
                .hospitalName(reservation.getDoctor().getDepartment().getHospital().getName())
                .departmentName(reservation.getDoctor().getDepartment().getName())
                .time(reservation.getTime())
                .price(reservation.getPrice())
                .status(reservation.getStatus())
                .content(reservation.getContent())
                .build();
    }


    public static Reservation toReservation(ReservationRequestDTO.createReservationDTO request, Patient patient, Doctor doctor){
        return Reservation.builder()
                .patient(patient)
                .doctor(doctor)
                .time(request.getTime())
                .price(request.getPrice())
                .content(request.getContent())
                .build();
    }
}
