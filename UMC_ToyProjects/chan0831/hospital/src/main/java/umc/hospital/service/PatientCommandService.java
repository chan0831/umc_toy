package umc.hospital.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.hospital.domain.Patient;
import umc.hospital.web.dto.PatientRequestDTO;


public interface PatientCommandService {

    Patient joinPatient(PatientRequestDTO.JoinDTO request);
}
