package umc.hospital.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

public class PatientResponseDTO {

    @Getter
    @Builder
    @RequiredArgsConstructor
    @AllArgsConstructor
    public static class JoinResultDTO{

        Long patientId;
        LocalDateTime createdAt;
    }
}
