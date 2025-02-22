package com.example.mbs.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Booking> bookings;

    public User() {}

    public User(int id, String name, String email, List<Booking> bookings) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.bookings = bookings;
    }

    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }

    public String getEmail(){
        return email;
    }
    
    public void setEmail(String email){
        this.email = email;
    }

    public List<Booking> getBookings(){
        return bookings;
    }
    
    public void setBookings(List<Booking> bookings){
        this.bookings = bookings;
    }

    
}
