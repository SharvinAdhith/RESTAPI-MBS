package com.example.mbs.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Version;

@Entity
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String name;
    private String contactInfo;
  
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BoatHouse> boatHouses;

    @Version
    private int version;

    // Constructors, getters, and setters
    public Owner() {
    }

    public Owner(int id, String name, String contactInfo, List<BoatHouse> boatHouses) {
        this.id = id;
        this.name = name;
        this.contactInfo = contactInfo;
        this.boatHouses = boatHouses;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public List<BoatHouse> getBoatHouses() {
        return boatHouses;
    }

    public void setBoatHouses(List<BoatHouse> boatHouses) {
        this.boatHouses = boatHouses;
    }
}
