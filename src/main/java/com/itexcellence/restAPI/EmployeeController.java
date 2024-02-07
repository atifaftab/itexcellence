package com.itexcellence.restAPI;

import com.itexcellence.entity.Department;
import com.itexcellence.entity.Employee;
import com.itexcellence.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@AllArgsConstructor
public class EmployeeController {
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/department/{departmentId}")
    public List<Employee> getEmployeesByDepartment(@PathVariable String departmentId) {
        return employeeService.getEmployeesByDepartment(departmentId);
    }

    @PostMapping("/department/{departmentId}")
    public Employee addEmployee(@RequestBody Employee employee, @PathVariable String departmentId) {
        // Find department by ID and set it for the employee
        Department department = new Department();
        department.setId(departmentId);
        employee.setDepartment(department);

        return employeeService.addEmployee(employee);
    }

    @DeleteMapping("/{employeeId}")
    public void deleteEmployee(@PathVariable String employeeId) {
        employeeService.deleteEmployee(employeeId);
    }
}