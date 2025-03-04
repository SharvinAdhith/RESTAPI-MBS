package com.example.mbs.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "boat_house")
public class BoatHouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String location;
    private String amenities;
    
    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @OneToMany(mappedBy = "boatHouse", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Room> rooms;

    @OneToMany(mappedBy = "boatHouse", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Booking> bookings;



    public BoatHouse() {}

    public BoatHouse(int id, String name, String location, String amenities, Owner owner, 
                     List<Booking> bookings, List<Room> rooms) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.amenities = amenities;
        this.owner = owner;
        this.rooms = rooms;
        this.bookings = bookings;
    }

    public int getId(){
        return id;
    }

    public void setID(int id){
        this.id=id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getLocation(){
        return location;
    }

    public void setLocation(String location){
        this.location=location;
    }

    public String getAmenities(){
        return amenities;
    }

    public void setAmenities(String amenities){
        this.amenities=amenities;
    }

    public Owner getOwner(){
        return owner;
    }
    public void setOwner(Owner owner){
        this.owner = owner;
    }

    public List<Booking> getBookings(){
        return bookings;
    }
    public void setBookings(List<Booking> bookings){
        this.bookings = bookings;
    }

    // public List<Booking> getReserveboatHouse(){
    //     return reservations;
    // }

    // public void setReserveboatHouse(List<Booking> reserveboatHouse){
    //     this.reservations = reserveboatHouse;
    // }

    public List<Room> getRooms(){
        return rooms; 
    }

    public void setRooms(List<Room> rooms){
        this.rooms = rooms;
    }
}
