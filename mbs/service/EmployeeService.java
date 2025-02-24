package com.example.mbs.service;

import com.example.mbs.entity.Employee;
import com.example.mbs.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public Employee saveEmployee(Employee employee) {
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
