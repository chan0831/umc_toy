package umc.hospital.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.hospital.apiPayload.ApiResponse;
import umc.hospital.converter.PatientConverter;
import umc.hospital.domain.Patient;
import umc.hospital.service.patientService.PatientCommandService;
import umc.hospital.web.dto.PatientRequestDTO;
import umc.hospital.web.dto.PatientResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/patients")
public class PatientRestController {

    private final PatientCommandService patientCommandService;

    @PostMapping("/")
    public ApiResponse<PatientResponseDTO.JoinResultDTO> join(@RequestBody @Valid PatientRequestDTO.JoinDTO request){
        Patient patient = patientCommandService.joinPatient(request);

        return ApiResponse.onSuccess(PatientConverter.toJoinResultDTO(patient));
    }
}
