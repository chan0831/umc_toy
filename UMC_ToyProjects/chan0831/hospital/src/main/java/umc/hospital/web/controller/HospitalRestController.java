package umc.hospital.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.hospital.apiPayload.ApiResponse;
import umc.hospital.converter.HospitalConverter;
import umc.hospital.domain.Hospital;
import umc.hospital.service.hospitalService.HospitalCommandService;
import umc.hospital.service.hospitalService.HospitalCommandServiceImpl;
import umc.hospital.service.hospitalService.HospitalQueryService;
import umc.hospital.web.dto.HospitalRequestDTO;
import umc.hospital.web.dto.HospitalResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/hospitals")
public class HospitalRestController {

    private final HospitalCommandService hospitalCommandService ;

    @PostMapping("/{hospitalId}")
    public ApiResponse<HospitalResponseDTO.selectHospitalResultDTO> selectHospital
            (@PathVariable Long hospitalId){

        Hospital hospital = hospitalCommandService.findById(hospitalId);

        return ApiResponse.onSuccess(HospitalConverter.toSelectResponseDTO(hospital));
    }
}
