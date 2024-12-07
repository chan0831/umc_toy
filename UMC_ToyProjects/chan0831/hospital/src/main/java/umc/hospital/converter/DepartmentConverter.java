package umc.hospital.converter;

import umc.hospital.domain.Department;
import umc.hospital.domain.Hospital;
import umc.hospital.web.dto.DepartmentResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class DepartmentConverter {

    public static List<DepartmentResponseDTO.SelectDepartmentResultDTO> departmentResponseDTO(List<Department> departmentList){

        return departmentList.stream()
                .map(department -> new DepartmentResponseDTO.SelectDepartmentResultDTO(
                        department.getId(),department.getName(), department.getPhoneNum()))
                .collect(Collectors.toList());

    }
}



