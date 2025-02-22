package com.example.mbs.entity;

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
    private double cost;

    @ManyToOne
    @JoinColumn(name = "boathouse_id")
    private BoatHouse boatHouse;
}
