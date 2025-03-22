package com.example.mbs.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String category;
    private int roomno;
    private String status;
    private double price;

    @ManyToOne
    @JoinColumn(name = "boatHouse_id")
    private BoatHouse boatHouse;

    @ManyToOne
    @JoinColumn(name = "booking_id")
    private Booking bookings;
}
