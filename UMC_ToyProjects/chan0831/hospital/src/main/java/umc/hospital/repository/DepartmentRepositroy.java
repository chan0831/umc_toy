package umc.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.hospital.domain.Department;

public interface DepartmentRepositroy extends JpaRepository<Department, Long> {
}
