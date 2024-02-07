package com.itexcellence.service;

import com.itexcellence.entity.Department;
import com.itexcellence.entity.Employee;
import com.itexcellence.repository.DepartmentRepository;
import com.itexcellence.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class DepartmentService {
    private DepartmentRepository departmentRepository;
    private EmployeeRepository employeeRepository;

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department addDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Transactional
    public void deleteEmployeeInDepartmentId(String departmentId, String employeeId) {

//
//        Department byId = departmentRepository.findById(departmentId).get();
//        byId.setEmployees(byId.getEmployees().stream().filter(i->(!i.getId().equalsIgnoreCase(employeeId))).collect(Collectors.toList()));
//      departmentRepository.saveAndFlush(byId);

           employeeRepository.deleteById(employeeId);

    }

    public List<Employee> getAllEmployeeByDeptID(String departmentId) {
        return departmentRepository.findById(departmentId).get().getEmployees();
    }

    @Transactional
    public Department addNewEmployeeInDepartmentId(String departmentId, Employee employee) {
//        return departmentRepository.findById(departmentId)
//                .map(department -> {
//                    department.getEmployees().add(employee);
//                    return departmentRepository.save(department);
//                }).get();
        Department department = departmentRepository.findById(departmentId).get();
        employee.setDepartment(department);
        employeeRepository.save(employee);
        return departmentRepository.findById(departmentId).get();
    }
}