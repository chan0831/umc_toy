package umc.hospital.service.hospitalService;

import umc.hospital.domain.Hospital;
import umc.hospital.web.dto.HospitalRequestDTO;
import umc.hospital.web.dto.HospitalResponseDTO;

public interface HospitalCommandService {

    Hospital findById(Long id);
}
