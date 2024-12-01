package umc.hospital.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.hospital.converter.PatientConverter;
import umc.hospital.domain.Patient;
import umc.hospital.repository.PatientRepository;
import umc.hospital.web.dto.PatientRequestDTO;

@Service
@RequiredArgsConstructor
public class PatientCommandServiceImpl implements PatientCommandService{

    private final PatientRepository patientRepository;

    @Override
    @Transactional
    public Patient joinPatient(PatientRequestDTO.JoinDTO request) {

        Patient newPatient = PatientConverter.toPatient(request);
        return patientRepository.save(newPatient);

    }
}
