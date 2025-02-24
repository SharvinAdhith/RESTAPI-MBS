package com.example.mbs.entity;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private LocalDate startDate;

    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "room_id")
    @JsonIgnore
    private Room room;

    @ManyToOne
    @JoinColumn(name = "boathouse_id")
    @JsonIgnore
    private BoatHouse boatHouse;  // Main BoatHouse

    public Booking() {}

    public Booking(int id, LocalDate startDate, LocalDate endDate, User user, Room room, BoatHouse boatHouse) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.user = user;
        this.room=room;
        this.boatHouse = boatHouse;
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

    // public BoatHouse getReserveBoatHouse(){
    //     return reserveboatHouse;
    // }

    // public void setReserveBoatHouse(BoatHouse reserveboatHouse){
    //     this.reserveboatHouse=reserveboatHouse;
    // }

    public Room getRoom() {
        return room;
    }
    public void setRoom(Room room) {
        this.room = room;
    }
}
