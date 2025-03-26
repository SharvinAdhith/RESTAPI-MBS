package com.example.mbs.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "boat_house")
public class BoatHouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String location;
    private String amenities;
    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    @JsonBackReference
    private Owner owner;
    private String roomdetails;
    private double price;
    public BoatHouse() {}
    public BoatHouse(int id, String name, String location, String amenities, Owner owner,
                String roomdetails,double price) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.amenities = amenities;
        this.owner = owner;
        this.roomdetails=roomdetails;
        this.price=price;
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
    public String getroomdetails(){
        return roomdetails;
    }
    public void setroomdetails(String roomdetails){
        this.roomdetails = roomdetails;
    }
    public Double getPrice(){
        return price;
    }
    public void setPrice(Double price){
        this.price = price;
    }
}