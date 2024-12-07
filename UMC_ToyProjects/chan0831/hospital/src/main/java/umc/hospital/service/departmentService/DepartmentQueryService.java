package umc.hospital.service.departmentService;

import umc.hospital.domain.Hospital;
import umc.hospital.web.dto.DepartmentResponseDTO;

import java.util.List;

public interface DepartmentQueryService {
    List<DepartmentResponseDTO.SelectDepartmentResultDTO> selectDepartmentResult(Long hospitalId);
}
