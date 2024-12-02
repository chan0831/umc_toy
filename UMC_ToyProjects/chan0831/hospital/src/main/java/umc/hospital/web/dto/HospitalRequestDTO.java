package umc.hospital.web.dto;

import lombok.Getter;

public class HospitalRequestDTO {
    @Getter
    public static class selectHospitalDTO{
        private Long id;
        private String name;
        private String address;

    }
}
