package com.example.demo.service;

<<<<<<< HEAD
=======
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

>>>>>>> 172ed910c6ce040bca5a2a2109e859a28d3b9cac
import com.example.demo.model.Car;
import com.example.demo.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    // Injecting the CarRepository for database operations
    @Autowired
    private CarRepository carRepository;

    // Method to fetch a car by ID
    public Car getCarById(Long id) {
        Optional<Car> car = carRepository.findById(id);
        return car.orElse(null); // Return the car if found, or null if not found
    }

    // Method to update a car's details by ID
    public Car updateCar(Long id, Car car) {
        // Check if car with the given ID exists
        if (carRepository.existsById(id)) {
            car.setId(id); // Ensure the car's ID is set for updating
            return carRepository.save(car); // Save the updated car
        }
        return null; // Return null if the car doesn't exist
    }

    // Method to delete a car by ID
    public void deleteCar(Long id) {
        // Only delete if the car exists in the database
        if (carRepository.existsById(id)) {
            carRepository.deleteById(id);
        }
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
