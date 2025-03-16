package com.example.demo.controller;

import com.example.demo.model.Car;
import com.example.demo.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
@CrossOrigin(origins = "http://localhost:3000") // Allow frontend requests
public class CarController {

    @Autowired
    private CarService carService;

    // Get all available cars (you can add more logic like filtering by status if needed)
    @GetMapping("/available-cars")
    public List<Car> getAvailableCars() {
        return carService.getAvailableCars();
    }

    // Get car by ID
    @GetMapping("/{id}")
<<<<<<< HEAD
    public Car getCarById(@PathVariable Integer id) {
        return carService.getCarById(id);
=======
    public Car getCarById(@PathVariable Long id) {
        return carService.getCarById(id)
                .orElseThrow(() -> new RuntimeException("Car not found with ID: " + id)); // Handle case if car is not found
>>>>>>> 172ed910c6ce040bca5a2a2109e859a28d3b9cac
    }

    // Add a new car
    @PostMapping("/add-car")
    public Car addCar(@RequestBody Car car) {
        return carService.addCar(car);
    }

    // Update car details
    @PutMapping("/update/{id}")
    public Car updateCar(@PathVariable Integer id, @RequestBody Car updatedCar) {
        return carService.updateCar(id, updatedCar);
    }

    // Delete a car
    @DeleteMapping("/delete/{id}")
    public void deleteCar(@PathVariable Integer id) {
        carService.deleteCar(id);
    }
}
