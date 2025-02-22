package com.example.mbs.repository;

import com.example.mbs.entity.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    // Pagination support
    @SuppressWarnings("null")
    Page<Department> findAll(Pageable pageable);
}
