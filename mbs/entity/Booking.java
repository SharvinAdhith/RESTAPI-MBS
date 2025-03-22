    package com.example.mbs.entity;

    import java.time.LocalDate;
    import java.util.HashSet;
    import java.util.List;
    import java.util.Set;
    import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
    import jakarta.persistence.CascadeType;
    import jakarta.persistence.Entity;
    import jakarta.persistence.GeneratedValue;
    import jakarta.persistence.GenerationType;
    import jakarta.persistence.Id;
    import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
    import jakarta.persistence.OneToOne;

    @Entity
    public class Booking {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        @DateTimeFormat(pattern = "MM/dd/yyyy")
        private LocalDate startDate;

        @DateTimeFormat(pattern = "MM/dd/yyyy")
        private LocalDate endDate;

        @OneToMany(cascade = CascadeType.ALL)
        @JsonManagedReference
        private Set<User> users= new HashSet<>();

        @OneToMany(mappedBy = "bookings", cascade = CascadeType.ALL)
        @JsonManagedReference
        private List<Room> rooms;

        @ManyToOne
        @JoinColumn(name = "boatHouse_id")
        @JsonBackReference
        private BoatHouse boatHouse;  // Main BoatHouse

        @OneToOne(cascade=CascadeType.ALL)
        @JoinColumn(name="payment_id")
        @JsonManagedReference
        private Payment payment;
        public Booking() {}

        public Booking(int id, LocalDate startDate, LocalDate endDate, Set<User> users, List<Room> rooms, BoatHouse boatHouse, Payment payment) {
            this.id = id;
            this.startDate = startDate;
            this.endDate = endDate;
            this.users = users;
            this.rooms=rooms;
            this.boatHouse = boatHouse;
            this.payment=payment;
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

        public Set<User> getUser(){
            return users;
        }

        public void setUser(Set<User> users){
            this.users = users;
        }

        public BoatHouse getBoatHouse(){
            return boatHouse;
        }

        public void setBoatHouse(BoatHouse boatHouse){
            this.boatHouse = boatHouse;
        }

        public List<Room> getRoom() {
            return rooms;
        }
        public void setRoom(List<Room> rooms) {
            this.rooms = rooms;
        }

        public Payment getpayment(){
            return payment;
        }
        public void setpayment(Payment payment){
            this.payment = payment;
        }
    }
