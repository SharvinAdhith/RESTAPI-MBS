package com.example.mbs.entity;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.*;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ServiceBH {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int servid;
    private String description;
    private String noofmin;
    private double cost;
    @ManyToMany(mappedBy = "services") // The other side of the ManyToMany relationship
    @JsonBackReference
    @JsonIgnore
    private Set<User> users = new HashSet<>();
}
