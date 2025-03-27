package com.example.mbs.entity;
import java.util.ArrayList;
import java.util.List;
// import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private String registrationNumber;
    private String ownerType; //e.g., "Individual, "Company"
    private int numberOfBoatHouses;
    private String status; // e.g., "Active", "Inactive", "Suspended"
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonManagedReference
    private List<BoatHouse> boatHouses=new ArrayList<>();
    public Owner() {
    }
    public Owner(int id, String name, String contactInfo, List<BoatHouse> boatHouses,
    String registrationNumber,String ownerType,int numberOfBoatHouses,String status) {
        this.id = id;
        this.name = name;
        this.contactInfo = contactInfo;
        this.boatHouses = boatHouses;
        this.registrationNumber=registrationNumber;
        this.ownerType=ownerType;
        this.numberOfBoatHouses=numberOfBoatHouses;
        this.status=status;
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
    public String getRegistrationNumber() {
        return registrationNumber;
    }
    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }
    public String getOwnerType() {
        return ownerType;
    }
    public void setOwnerType(String ownerType) {
        this.ownerType = ownerType;
    }
    public int getNumberOfBoatHouses(){
        return numberOfBoatHouses;
    }
    public void setNumberOfBoatHouses(int numberOfBoatHouses){
        this.numberOfBoatHouses=numberOfBoatHouses;
    }
    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status=status;
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
    public void addBoatHouse(BoatHouse boatHouse) {
        boatHouses.add(boatHouse);
        boatHouse.setOwner(this);
    }
    
    public void removeBoatHouse(BoatHouse boatHouse) {
        boatHouses.remove(boatHouse);
        boatHouse.setOwner(null);
    }
}