package com.example.demo.repository;

import com.example.demo.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {

    // Custom query to find cars by status
    List<Car> findByStatus(String status);  // This will return all cars with the given status
}
