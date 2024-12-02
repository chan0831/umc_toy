package umc.hospital.converter;

import umc.hospital.domain.Hospital;
import umc.hospital.web.dto.HospitalRequestDTO;
import umc.hospital.web.dto.HospitalResponseDTO;

public class HospitalConverter {

    public static HospitalResponseDTO.selectHospitalResultDTO toSelectResponseDTO
            (Hospital hospital){
        return HospitalResponseDTO.selectHospitalResultDTO.builder()
                .id(hospital.getId())
                .address(hospital.getAddress())
                .name(hospital.getName())
                .build();
    }

    //public static Hospital toHospital(HospitalRequestDTO.selectHospitalDTO request){}


}
