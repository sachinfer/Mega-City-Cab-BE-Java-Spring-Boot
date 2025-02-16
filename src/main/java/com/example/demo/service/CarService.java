package com.example.demo.service;

import com.example.demo.model.Car;
import com.example.demo.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    // Get available cars from the database
    public List<Car> getAvailableCars() {
        return carRepository.findByStatus("Available");  // Query repository for cars with status 'Available'
    }
}
