package com.example.mbs.service;

import com.example.mbs.entity.Booking;
import com.example.mbs.repository.BookingRepository;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookingService {
    @Autowired
    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public ResponseEntity<String> saveBooking(@RequestBody Booking bookings) {
        bookingRepository.save(bookings);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Booking is successfully done!");
    }
    
    public Booking getBookingByID(int id){
        return bookingRepository.findById(id);
    }

    public Booking updateBookingDetails(int id, Booking bookings){
        bookings.setId(id);
        return bookingRepository.save(bookings);
    }
    
    public String deleteBooking(int id){
        bookingRepository.deleteById(id);
        return "Successfully Deleted The Booking Details";
    }

    public Page<Booking> getBookingByPage(int page, int size){
        Pageable pageable=PageRequest.of(page, size);
        return bookingRepository.findAll(pageable);
    }
}
