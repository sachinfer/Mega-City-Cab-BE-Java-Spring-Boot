package com.example.demo.service;

import com.example.demo.model.Car;
import com.example.demo.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    // Injecting the CarRepository for database operations
    @Autowired
    private CarRepository carRepository;

    // Method to fetch all available cars (you can add more filtering logic if needed)
    public List<Car> getAvailableCars() {
        return carRepository.findAll();  // Assuming you want to fetch all cars
    }

    // Method to fetch a car by ID
    public Optional<Car> getCarById(Long id) {
        return carRepository.findById(id);  // Return Optional to handle missing cars gracefully
    }

    // Method to update a car's details by ID
    public Car updateCar(Long id, Car car) {
        // Check if car with the given ID exists
        if (!carRepository.existsById(id)) {
            throw new RuntimeException("Car not found with ID: " + id);  // Handle the error if car doesn't exist
        }
        car.setId(id);  // Ensure the car's ID is set for updating
        return carRepository.save(car);  // Save the updated car
    }

    // Method to delete a car by ID
    public void deleteCar(Long id) {
        // Only delete if the car exists in the database
        if (!carRepository.existsById(id)) {
            throw new RuntimeException("Car not found with ID: " + id);  // Handle the error if car doesn't exist
        }
        carRepository.deleteById(id);  // Delete the car from the database
    }

    // Add a new car
    public Car addCar(Car car) {
        return carRepository.save(car);  // Save the new car to the database
    }
}
