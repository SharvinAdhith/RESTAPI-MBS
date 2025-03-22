package com.example.mbs.entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empId;
    private String name;
    private double salary;
    private String address;
    private String phoneNo;
    private String gender;
    
    @ManyToMany
    @JoinTable(
        name = "employee_department", // Join table to associate Employee and Department
        joinColumns = @JoinColumn(name = "emp_id"),
        inverseJoinColumns = @JoinColumn(name = "dept_id")
    )
    private List<Department> department;
}
