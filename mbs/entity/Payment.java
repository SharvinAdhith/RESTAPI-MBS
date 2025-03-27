package com.example.mbs.entity;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;
import lombok.*;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double platformfee;
    private double taxamount;
    private double totalamount;
    private String method; 
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private LocalDate paymentDate;
    private String transactionID;
    @OneToOne
    @JoinColumn(name = "booking_id")  // Foreign key in Payment table
    @JsonBackReference("booking-payment")
    private Booking booking;
}