package com.example.mbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.mbs.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
