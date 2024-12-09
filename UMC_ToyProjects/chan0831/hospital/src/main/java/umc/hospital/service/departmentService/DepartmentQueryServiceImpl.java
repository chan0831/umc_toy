package umc.hospital.service.departmentService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.hospital.apiPayload.code.status.ErrorStatus;
import umc.hospital.apiPayload.exception.GeneralException;
import umc.hospital.converter.DepartmentConverter;
import umc.hospital.domain.Department;
import umc.hospital.domain.Hospital;
import umc.hospital.repository.DepartmentRepositroy;
import umc.hospital.repository.HospitalRepository;
import umc.hospital.web.dto.DepartmentResponseDTO;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class DepartmentQueryServiceImpl implements DepartmentQueryService{

    private final DepartmentRepositroy departmentRepositroy;
    @Override
    public List<DepartmentResponseDTO.SelectDepartmentResultDTO> selectDepartmentResult(Long hospitalId) {

        List< Department > departmentList = departmentRepositroy.findByHospitalId(hospitalId);

        return DepartmentConverter.departmentResponseDTO(departmentList);


    }
}
