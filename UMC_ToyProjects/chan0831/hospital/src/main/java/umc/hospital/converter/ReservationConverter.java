package umc.hospital.converter;

import umc.hospital.domain.Doctor;
import umc.hospital.domain.Hospital;
import umc.hospital.domain.Patient;
import umc.hospital.domain.Reservation;
import umc.hospital.web.dto.ReservationRequestDTO;
import umc.hospital.web.dto.ReservationResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

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

    public static List<ReservationResponseDTO.ReservationResultDTO> toReservationListDTO(List<Reservation> reservationList){

        return reservationList.stream()
                .map(reservation -> new ReservationResponseDTO.ReservationResultDTO(
                        reservation.getPatient().getName(),
                        reservation.getDoctor().getDepartment().getHospital().getName(),
                        reservation.getTime(),
                        reservation.getDoctor().getName(),
                        reservation.getPrice(),
                        reservation.getStatus(),
                        reservation.getDoctor().getDepartment().getName(),
                        reservation.getContent())
                ).collect(Collectors.toList());
    }
}
