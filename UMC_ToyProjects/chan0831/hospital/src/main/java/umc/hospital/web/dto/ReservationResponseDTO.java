package umc.hospital.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.hospital.domain.enums.RStatus;

import java.time.LocalDateTime;

public class ReservationResponseDTO {

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReservationResultDTO{


        private String patientName;
        private String hospitalName;
        private LocalDateTime time;
        private String doctorName;
        private int price;
        private RStatus status;
        private String departmentName;
        private String content;
    }
}
