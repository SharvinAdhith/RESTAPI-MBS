package com.example.mbs.controller;

import com.example.mbs.entity.Department;
import com.example.mbs.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/getDept")
    public ResponseEntity<List<Department>> getAllDepartments() {
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }

    @PostMapping("/postDept")
    public ResponseEntity<Department> createDepartment(@RequestBody Department department) {
        return ResponseEntity.ok(departmentService.saveDepartment(department));
    }

    @PutMapping("/updateDept/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable int id, @RequestBody Department department) {
        return ResponseEntity.ok(departmentService.updateDepartment(id, department));
    }

    @DeleteMapping("/deleteDept/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable int id) {
        departmentService.deleteDepartment(id);
        return ResponseEntity.ok("Department deleted successfully");
    }

    @GetMapping("/getDept/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable int id) {
        return ResponseEntity.ok(departmentService.getDepartmentById(id));
    }
    @GetMapping("/pageDept")
    public Page<Department> getDepartmentsByPage(@RequestParam(defaultValue = "0")int page, @RequestParam(defaultValue = "5")int size) {
      return departmentService.getDepartmentsByPage(page, size);
    }
    
}
