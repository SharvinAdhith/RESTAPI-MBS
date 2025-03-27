
package com.example.mbs.entity;
import java.util.HashSet;
import java.util.Set;
// import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String contactnumber;

    private String paymentmethod;
    @ManyToMany(cascade = {CascadeType.MERGE},  fetch = FetchType.EAGER)
    @JoinTable(
        name = "user_service",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "service_id")
    )
    // @JsonIgnore
    @JsonIgnoreProperties("users") 
    private Set<ServiceBH> services = new HashSet<>();

    public User() {}

    public User(int id, String name, String email, String paymentmethod, 
                Set<ServiceBH> services, String contactnumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.contactnumber = contactnumber;
        this.paymentmethod = paymentmethod;
        this.services = services;
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

    public String getContactnumber(){
        return contactnumber;
    }

    public void setContactnumber(String contactnumber){
        this.contactnumber = contactnumber;
    }

    public String getPaymentmethod(){
        return paymentmethod;
    }

    public void setPaymentmethod(String paymentmethod){
        this.paymentmethod = paymentmethod;
    }

    public Set<ServiceBH> getServices() { 
        return services; 
    }

    public void setServices(Set<ServiceBH> services) {
        this.services = services; 
    }
    public void addService(ServiceBH service) {
        this.services.add(service);
        service.getUsers().add(this);
    }
    public void removeService(ServiceBH service) {
        this.services.remove(service);
        service.getUsers().remove(this);
    }
}
