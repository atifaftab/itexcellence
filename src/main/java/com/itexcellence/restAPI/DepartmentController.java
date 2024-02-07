package com.itexcellence.restAPI;

import com.itexcellence.entity.Department;
import com.itexcellence.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
@AllArgsConstructor
public class DepartmentController {
    private DepartmentService departmentService;

    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @PostMapping
    public Department addDepartment(@RequestBody Department department) {
        System.out.println(department.getEmployees());
        return departmentService.addDepartment(department);
    }

    @DeleteMapping("/{departmentId}")
    public void deleteDepartment(@PathVariable String departmentId) {
        departmentService.deleteDepartment(departmentId);
    }
}