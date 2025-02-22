package com.example.mbs.entity;

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

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
}
