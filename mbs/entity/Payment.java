package com.example.mbs.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double amount;
    private String method; 

    @ManyToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;
}
