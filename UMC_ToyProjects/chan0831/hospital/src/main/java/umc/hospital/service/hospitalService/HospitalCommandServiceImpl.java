package umc.hospital.service.hospitalService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.hospital.apiPayload.ApiResponse;
import umc.hospital.apiPayload.code.status.ErrorStatus;
import umc.hospital.apiPayload.exception.GeneralException;
import umc.hospital.converter.HospitalConverter;
import umc.hospital.domain.Hospital;
import umc.hospital.repository.HospitalRepository;
import umc.hospital.web.dto.HospitalRequestDTO;
import umc.hospital.web.dto.HospitalResponseDTO;

@Service
@RequiredArgsConstructor
@Transactional
public class HospitalCommandServiceImpl implements HospitalCommandService{


    private final HospitalRepository hospitalRepository;

    @Override
    public Hospital findById(Long id) {

        return hospitalRepository.findById(id)
                .orElseThrow(()->new GeneralException(ErrorStatus.HOSPITAL_NOT_FOUND));
    }
}
