package com.example.mbs.entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int deptId;
    private String name;
    private String deptname;
    private String deptHead;

    @ManyToMany(mappedBy = "department")  // mappedBy points to the 'department' field in Employee
    private List<Employee> employees;
}
