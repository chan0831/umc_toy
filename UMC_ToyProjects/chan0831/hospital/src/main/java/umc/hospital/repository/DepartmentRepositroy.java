package umc.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.hospital.domain.Department;
import umc.hospital.domain.Hospital;

import java.util.List;

public interface DepartmentRepositroy extends JpaRepository<Department, Long> {
    List<Department> findByHospitalId(Long hospitalId);
}
