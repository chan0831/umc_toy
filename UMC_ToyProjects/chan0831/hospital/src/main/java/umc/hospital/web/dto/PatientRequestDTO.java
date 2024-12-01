package umc.hospital.web.dto;


import lombok.Getter;
import umc.hospital.domain.enums.Gender;

public class PatientRequestDTO {

    @Getter
    public static class JoinDTO{

        String name;
        int age;
        Gender gender;
    }
}
