package com.example.mbs.entity;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String contactInfo;
  
    @OneToMany(cascade=CascadeType.ALL)
    @JsonManagedReference
    private List<BoatHouse> boatHouses;
   

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
        for(BoatHouse boathouse:boatHouses){
            boathouse.setOwner(this);
        }
        this.boatHouses = boatHouses;
    }
}
