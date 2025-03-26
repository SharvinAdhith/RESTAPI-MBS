package com.example.mbs.controller;
import com.example.mbs.entity.Booking;
import com.example.mbs.service.BookingService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    @Autowired
    private final BookingService bookingService;
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/getbookings")
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @PostMapping("/postbookings")
    public ResponseEntity<String> createBooking(@RequestBody Booking bookings) {
        return bookingService.saveBooking(bookings);
    }

    @Transactional
    @PutMapping("/updatebookings/{id}")
    public  ResponseEntity<Booking> updateBookingDetails(@PathVariable int id, @RequestBody Booking bookings) {
        Booking updatedBooking = bookingService.updateBookingDetails(id, bookings); // Call the service method to handle the update logic
    return ResponseEntity.ok(updatedBooking);
    }
    
    @DeleteMapping("/deletebookings/{id}")
    public String deleteBooking(@PathVariable int id){
        return bookingService.deleteBooking(id);
    }

    @GetMapping("/getbookings/{id}")
    public Booking getBookingByID(@PathVariable int id){
        return bookingService.getBookingByID(id);
    }

    @GetMapping("/pagebookings")
    public Page<Booking> getBookingByPage(@RequestParam(defaultValue = "0")int page, @RequestParam(defaultValue = "5")int size) {
        return bookingService.getBookingByPage(page, size);
    }
    
}
