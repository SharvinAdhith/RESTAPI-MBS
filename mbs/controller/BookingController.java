package com.example.mbs.controller;
import com.example.mbs.entity.Booking;
import com.example.mbs.service.BookingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/getbk")
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @PostMapping("/postbk")
    public Booking createBooking(@RequestBody Booking bookings) {
        return bookingService.saveBooking(bookings);
    }

    @GetMapping("/getbh/{id}")
    public Booking getBookingByID(@PathVariable int id){
        return bookingService.getBookingByID(id);
    }

    @PutMapping("/updatebk/{id}")
    public Booking updateBookingDetails(@PathVariable int id, @RequestBody Booking bookings) {
       return bookingService.updateBookingDetails(id, bookings);
    }
    
    @DeleteMapping("/deletebk/{id}")
    public String deleteBooking(@PathVariable int id){
        return bookingService.deleteBooking(id);
    }

    @GetMapping("/pagebk")
    public Page<Booking> getBookingByPage(@RequestParam(defaultValue = "0")int page, @RequestParam(defaultValue = "5")int size) {
        return bookingService.getBookingByPage(page, size);
    }
}
