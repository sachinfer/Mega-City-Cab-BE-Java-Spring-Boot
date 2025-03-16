package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Automatically generate the ID
    private Integer id;

    private String make;
    private String model;
    private String status;  // Available, Rented, etc.
    private Integer quantity; // New field for quantity
    private Double price; // New field for price

    // Default constructor
    public Car() {}

    // Constructor for easy creation of Car instances
    public Car(String make, String model, String status, Integer quantity, Double price) {
        this.make = make;
        this.model = model;
        this.status = status;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
