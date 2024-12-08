package umc.hospital.web.dto;

import lombok.Getter;
import umc.hospital.domain.enums.RStatus;

import java.time.LocalDateTime;

public class ReservationRequestDTO {

    @Getter
    public static class createReservationDTO{

        private Long patientId;
        private Long doctorId;
        private LocalDateTime time;
        private int price;
        private String content;
    }
}
