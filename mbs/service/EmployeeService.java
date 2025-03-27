package com.example.mbs.service;

import com.example.mbs.entity.Department;
import com.example.mbs.entity.Employee;
import com.example.mbs.exception.ResourceNotFoundException;
import com.example.mbs.repository.DepartmentRepository;
import com.example.mbs.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
     @Autowired
    private DepartmentRepository departmentRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

        public Employee saveEmployee(Employee employee) {
    Objects.requireNonNull(employee, "Employee cannot be null");

    Optional.ofNullable(employee.getDepartment())
        .ifPresent(dept -> {
            Optional.ofNullable(dept.getDeptId())
                .ifPresentOrElse(
                    deptId -> {
                        Department existingDept = departmentRepository.findById(deptId)
                            .orElseThrow(() -> new ResourceNotFoundException(
                                "Department not found with id: " + deptId));
                        existingDept.setName(dept.getName());
                        existingDept.setDeptname(dept.getDeptname());
                        existingDept.setDeptHead(dept.getDeptHead());
                        employee.setDepartment(existingDept);
                    },
                    () -> {
                        Department savedDept = departmentRepository.save(dept);
                        employee.setDepartment(savedDept);
                    }
                );
        });
    
    return employeeRepository.save(employee);
}

    public Employee updateEmployee(int id, Employee employee) {
        employee.setEmpId(id);
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }

     public Page<Employee> getEmployeesByPage(int page, int size){
        Pageable pageable=PageRequest.of(page, size);
        return employeeRepository.findAll(pageable);
    }

    public List<Employee> sortByEmp(){
        return employeeRepository.findAll(Sort.by("salary").descending());
    }
}
