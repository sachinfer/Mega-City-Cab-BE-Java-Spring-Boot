package com.example.demo.controller;

import com.example.demo.model.Booking;
import com.example.demo.model.Car;
import com.example.demo.repository.BookingRepository;
import com.example.demo.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/billing")
public class BillingController {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private CarRepository carRepository;

    @GetMapping("/calculate/{bookingId}")
    public Map<String, Object> calculateBill(@PathVariable Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId).orElse(null);
        Map<String, Object> response = new HashMap<>();
        if (booking == null) {
            response.put("error", "Booking not found");
            return response;
        }

        Car car = carRepository.findById(Integer.parseInt(booking.getVehicleName())).orElse(null);
        if (car == null) {
            response.put("error", "Car not found");
            return response;
        }

        double basePrice = car.getPrice();
        double distance = 20.0; // Example distance in kilometers
        double ratePerKm = 10.0; // Example rate per kilometer
        double taxRate = 0.1; // 10% tax
        double discount = 0.05; // 5% discount

        double totalAmount = (basePrice + (distance * ratePerKm));
        double taxAmount = totalAmount * taxRate;
        double discountAmount = totalAmount * discount;
        double finalAmount = totalAmount + taxAmount - discountAmount;

        response.put("basePrice", basePrice);
        response.put("distance", distance);
        response.put("ratePerKm", ratePerKm);
        response.put("taxAmount", taxAmount);
        response.put("discountAmount", discountAmount);
        response.put("finalAmount", finalAmount);

        return response;
    }
}
