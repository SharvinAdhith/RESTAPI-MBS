package com.example.mbs.entity;
import java.util.HashSet;
import java.util.Set;

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
    // @ManyToMany
    // @JoinTable(
    //     name = "user_service",
    //     joinColumns = @JoinColumn(name = "service_id"),
    //     inverseJoinColumns = @JoinColumn(name = "user_id")
    // )
    // private Set<User> users = new HashSet<>();
    @ManyToMany(mappedBy = "services")
    @JsonIgnore 
    private Set<User> users = new HashSet<>();
}
