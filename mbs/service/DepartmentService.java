package com.example.mbs.service;

import com.example.mbs.entity.Department;
import com.example.mbs.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department getDepartmentById(int id) {
        return departmentRepository.findById(id).orElse(null);
    }

    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Department updateDepartment(int id, Department department) {
        department.setDeptId(id);
        return departmentRepository.save(department);
    }

    public void deleteDepartment(int id) {
        departmentRepository.deleteById(id);
    }

    public Page<Department> getDepartmentsByPage(int page, int size){
        Pageable pageable=PageRequest.of(page, size);
        return departmentRepository.findAll(pageable);
    }
}
