package com.example.mbs.service;

import com.example.mbs.entity.Booking;
import com.example.mbs.entity.Room;
import com.example.mbs.exception.ResourceNotFoundException;
import com.example.mbs.repository.BookingRepository;
import com.example.mbs.repository.RoomRepository;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookingService {
    @Autowired
    private final BookingRepository bookingRepository;

    @Autowired
    private RoomRepository roomRepository;
    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }
    @Transactional(readOnly = true)
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }
    
    public ResponseEntity<String> saveBooking(@RequestBody Booking booking) {
        // Handle room association if provided
        if (booking.getRoom() != null && booking.getRoom().getId() != 0) {
            Room room = roomRepository.findById(booking.getRoom().getId())
                .orElseThrow(() -> new ResourceNotFoundException(
                    "Room not found with id: " + booking.getRoom().getId()));
            booking.setRoom(room);
        }
        
        // Handle payment association
        if (booking.getPayment() != null) {
            booking.getPayment().setBooking(booking);
        }
        
        bookingRepository.save(booking);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Booking is successfully done!");
    }
    public Booking getBookingByID(int id) {
        return bookingRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Booking with ID " + id + " not found"));
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
