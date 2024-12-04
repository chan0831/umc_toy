package umc.hospital.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.hospital.apiPayload.ApiResponse;
import umc.hospital.converter.HospitalConverter;
import umc.hospital.domain.Department;
import umc.hospital.domain.Hospital;
import umc.hospital.service.HospitalDetailService.HospitalDetailQueryServiceImpl;
import umc.hospital.service.hospitalService.HospitalCommandService;
import umc.hospital.service.hospitalService.HospitalCommandServiceImpl;
import umc.hospital.service.hospitalService.HospitalQueryService;
import umc.hospital.web.dto.DepartmentResponseDTO;
import umc.hospital.web.dto.HospitalRequestDTO;
import umc.hospital.web.dto.HospitalResponseDTO;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/hospitals")
public class HospitalRestController {

    private final HospitalCommandService hospitalCommandService ;
    private final HospitalDetailQueryServiceImpl hospitalDetailQueryServiceImpl;

    @PostMapping("/{hospitalId}")
    public ApiResponse<HospitalResponseDTO.selectHospitalResultDTO> selectHospital
            (@PathVariable Long hospitalId){

        Hospital hospital = hospitalCommandService.findById(hospitalId);

        return ApiResponse.onSuccess(HospitalConverter.toSelectResponseDTO(hospital));
    }

    @GetMapping("/{hospitalId}/departments")
    public ApiResponse<List<DepartmentResponseDTO.SelectDepartmentResultDTO>> getDepartments(@PathVariable Long hospitalId){
        List<DepartmentResponseDTO.SelectDepartmentResultDTO> result = hospitalDetailQueryServiceImpl.getDepartmentsByHospital(hospitalId);

        return ApiResponse.onSuccess(result);
    }
}
