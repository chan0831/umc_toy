package umc.hospital.converter;

import umc.hospital.domain.Patient;
import umc.hospital.web.dto.PatientRequestDTO;
import umc.hospital.web.dto.PatientResponseDTO;

import java.time.LocalDateTime;

public class PatientConverter {

    public static PatientResponseDTO.JoinResultDTO toJoinResultDTO(Patient patient){
        return PatientResponseDTO.JoinResultDTO.builder()
                .patientId(patient.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Patient toPatient(PatientRequestDTO.JoinDTO request){
        return Patient.builder()
                .name(request.getName())
                .age(request.getAge())
                .gender(request.getGender())
                .build();
    }
}
