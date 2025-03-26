package com.example.mbs.entity;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private LocalDate startDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private LocalDate endDate;
    @ManyToOne
    @JoinColumn(name = "room_id")  // Foreign key column in Booking table
    @JsonBackReference
    private Room room;
    private String boatHouse; 
    private String bookingId;
    @OneToOne(mappedBy = "booking", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Payment payment;
    public Booking() {}
    public Booking(int id, LocalDate startDate, LocalDate endDate, Room room, 
            String boatHouse, Payment payment,String bookingId) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.room = room;
        this.bookingId=bookingId;
        this.boatHouse = boatHouse;
        this.payment = payment;
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
    public String getBoatHouse(){
        return boatHouse;
    }
    public void setBoatHouse(String boatHouse){
        this.boatHouse = boatHouse;
    }
    public Room getRoom() { 
        return room; 
    }
    public void setRoom(Room room) { 
        this.room = room; 
    }
    public String getBookingId(){
        return bookingId;
    }
    public void setBookingId(String bookingId){
        this.bookingId=bookingId;
    }
    public Payment getPayment() { 
        return payment; 
    }
    public void setPayment(Payment payment) { 
        this.payment = payment; 
    }
    public Booking orElseThrow(Object object) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'orElseThrow'");
    }
}