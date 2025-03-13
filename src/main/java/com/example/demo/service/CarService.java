package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Car;
import com.example.demo.repository.CarRepository;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    // Get available cars from the database
    public List<Car> getAvailableCars() {
        return carRepository.findByStatus("Available");  // Query repository for cars with status 'Available'
    }

    // Add a new car to the database
    public Car addCar(Car car) {
        return carRepository.save(car);
    }
}
