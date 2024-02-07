package com.itexcellence.service;

import com.itexcellence.entity.Employee;
import com.itexcellence.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll().stream().map(i->{
            System.out.println(i.getDepartment());
            return i;
        }).collect(Collectors.toList());
    }

    public List<Employee> getEmployeesByDepartment(String departmentId) {
        return employeeRepository.findByDepartmentId(departmentId);
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(String employeeId) {
        employeeRepository.deleteById(employeeId);
    }
}