package com.example.mbs.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate startDate;
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "boathouse_id")
    private BoatHouse boatHouse;  // Main BoatHouse

    @ManyToOne
    @JoinColumn(name = "reserve_boathouse_id")
    private BoatHouse reserveboatHouse;  // Reserved BoatHouse

    public Booking() {}

    public Booking(int id, LocalDate startDate, LocalDate endDate, User user, BoatHouse boatHouse, BoatHouse reserveboatHouse) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.user = user;
        this.boatHouse = boatHouse;
        this.reserveboatHouse = reserveboatHouse;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public LocalDate getStartDate(){
        return startDate;
    }

    public void setStartDate(LocalDate startDate){
        this.startDate = startDate;
    }

    public LocalDate getEndDate(){
        return endDate;
    }

    public void setEndDate(LocalDate endDate){
        this.endDate = endDate;
    }

    public User getUser(){
        return user;
    }

    public void setUser(User user){
        this.user = user;
    }

    public BoatHouse getBoatHouse(){
        return boatHouse;
    }

    public void setBoatHouse(BoatHouse boatHouse){
        this.boatHouse = boatHouse;
    }

    public BoatHouse getReserveBoatHouse(){
        return reserveboatHouse;
    }

    public void setReserveBoatHouse(BoatHouse reserveboatHouse){
        this.reserveboatHouse=reserveboatHouse;
    }
}
