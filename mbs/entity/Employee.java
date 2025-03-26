package com.example.mbs.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @OneToOne(cascade = CascadeType.ALL) // Owning side
    @JoinColumn(name = "department_id")  // Foreign key in Employee table
    @JsonManagedReference
    @JsonIgnore
    private Department department;
}