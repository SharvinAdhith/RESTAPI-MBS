package com.example.mbs.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @OneToOne(mappedBy = "department")  // Non-owning side
    @JsonBackReference
    @JsonIgnore
    private Employee employee;
}