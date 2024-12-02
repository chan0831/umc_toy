package umc.hospital.service.patientService;

import umc.hospital.domain.Patient;
import umc.hospital.web.dto.PatientRequestDTO;


public interface PatientCommandService {

    Patient joinPatient(PatientRequestDTO.JoinDTO request);
}
