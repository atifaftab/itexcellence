package com.itexcellence.restAPI;

import com.itexcellence.entity.Department;
import com.itexcellence.entity.Employee;
import com.itexcellence.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
@CrossOrigin
public class DepartmentController {
    private DepartmentService departmentService;

    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/getAllEmployeeByDept/{departmentId}")
    public List<Employee> getAllEmployeeByDept(@PathVariable String departmentId){
        return departmentService.getAllEmployeeByDeptID(departmentId);
    }

    @PostMapping
    public Department addDepartment(@RequestBody Department department) {
        System.out.println(department.getEmployees());
        return departmentService.addDepartment(department);
    }

    @PutMapping("/addNewEmployeeInDepartment/{departmentId}")
    public Department addNewEmployeeInDepartment(@PathVariable String departmentId, @RequestBody Employee employee){
        return departmentService.addNewEmployeeInDepartmentId(departmentId, employee);
    }

    @DeleteMapping("deleteEmployeeInDepartment/{departmentId}/{employeeId}")
    public void deleteEmployeeInDepartment(@PathVariable String departmentId, @PathVariable String employeeId) {
        departmentService.deleteEmployeeInDepartmentId(departmentId, employeeId);
    }

//    @GetMapping("/getdepartmentsById/{departmentId}")
//    public Department getdepartmentsById()
//
@GetMapping("/{departmentId}")
public Optional<Department> getAllDepartmentbyId(@PathVariable String departmentId) {
    return departmentService.getAllDepartmentById(departmentId);
}


}