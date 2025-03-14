package com.example.demo.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "booking")
public class Booking {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String address;
    private String phoneNumber;
    private String email;
    private String vehicleName;
    private LocalTime time;
    private LocalDate date;

    @Column(nullable = false)
    private String status = "PENDING"; // ✅ Default value to prevent NULL errors

    @Column(nullable = false)
    private String destination; // ✅ Added destination field

    @Column(nullable = false)
    private BigDecimal price; // ✅ Added price field for the booking price

    // Constructors
    public Booking() {}

    public Booking(String name, String address, String phoneNumber, String email, String vehicleName, 
                   LocalTime time, LocalDate date, String status, String destination, BigDecimal price) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.vehicleName = vehicleName;
        this.time = time;
        this.date = date;
        this.status = (status != null) ? status : "PENDING"; // ✅ Ensure non-null value
        this.destination = destination;
        this.price = price; // ✅ Set price
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getVehicleName() { return vehicleName; }
    public void setVehicleName(String vehicleName) { this.vehicleName = vehicleName; }

    public LocalTime getTime() { return time; }
    public void setTime(LocalTime time) { this.time = time; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public String getStatus() { return status; }
    public void setStatus(String status) { 
        this.status = (status != null) ? status : "PENDING"; // ✅ Ensure default value
    }

    public String getDestination() { return destination; }
    public void setDestination(String destination) { this.destination = destination; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }
}
