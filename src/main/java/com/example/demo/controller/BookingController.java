package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Booking;
import com.example.demo.service.BookingService;
import com.example.demo.service.EmailService;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin(origins = "http://localhost:3000") // Allow React frontend
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private EmailService emailService;

    // Save a new booking (POST request)
    @PostMapping("/submit") // Changed endpoint to "/submit" as per your request
    public ResponseEntity<Booking> saveBooking(@RequestBody Booking booking) {
        // Save the booking to the database
        Booking savedBooking = bookingService.saveBooking(booking);
        System.out.println("Booking created: " + savedBooking);

        // Send a booking confirmation email
        emailService.sendBookingConfirmation(
                booking.getEmail(),
                booking.getName(),
                booking.getVehicleName(),
                booking.getDate().toString(),
                booking.getTime().toString()
        );

        return ResponseEntity.ok(savedBooking);
    }

    // Get all bookings (GET request)
    @GetMapping
    public ResponseEntity<List<Booking>> getAllBookings() {
        List<Booking> bookings = bookingService.getAllBookings();
        return ResponseEntity.ok(bookings);
    }
}
