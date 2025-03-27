package com.example.mbs.entity;
import java.util.ArrayList;
import java.util.List;

// import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String category;

    @Column(unique = true)
    private int roomno;
    private String status;
    private String amenities;
    private double price;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER)
    @JsonManagedReference("room-bookings")
    // @JsonIgnore
    private List<Booking> bookings = new ArrayList<>();

    public void addBooking(Booking booking) {
        bookings.add(booking);
        booking.setRoom(this);
    }
    
    public void removeBooking(Booking booking) {
        bookings.remove(booking);
        booking.setRoom(null);
    }
}