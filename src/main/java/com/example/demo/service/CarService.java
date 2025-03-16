package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Car;
import com.example.demo.repository.CarRepository;

import java.util.List;
import java.util.Optional;

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

    // Get a car by its ID
    public Optional<Car> getCarById(Long id) {
        return carRepository.findById(id);  // Find car by its ID from the database
    }

    // Update an existing car's details
    public Car updateCar(Long id, Car car) {
        // Check if the car with the provided ID exists
        if (!carRepository.existsById(id)) {
            throw new RuntimeException("Car not found");  // Throw an exception if the car doesn't exist
        }
        car.setId(id);  // Make sure the car's ID is set correctly
        return carRepository.save(car);  // Save the updated car details
    }

    // Delete a car by its ID
    public void deleteCar(Long id) {
        if (!carRepository.existsById(id)) {
            throw new RuntimeException("Car not found");  // Throw an exception if the car doesn't exist
        }
        carRepository.deleteById(id);  // Delete the car from the database
    }
}
