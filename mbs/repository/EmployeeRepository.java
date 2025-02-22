package com.example.mbs.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.mbs.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // Pagination support
    @SuppressWarnings("null")
    Page<Employee> findAll(Pageable pageable);
}
