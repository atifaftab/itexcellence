package com.itexcellence.repository;

import com.itexcellence.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
    List<Employee> findByDepartmentId(String departmentId);
}