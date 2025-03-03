package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Booking;

public interface OrderRepository extends JpaRepository<Booking, Integer> {

    // Custom query to find cars by status
    List<Booking> findByStatus(String status);  // This will return all cars with the given status
}
