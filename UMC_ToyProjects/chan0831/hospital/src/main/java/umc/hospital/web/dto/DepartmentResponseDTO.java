package umc.hospital.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class DepartmentResponseDTO {

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SelectDepartmentResultDTO{

        private Long departmentId;
        private String departmentName;
        private String phoneNum;


    }
}
