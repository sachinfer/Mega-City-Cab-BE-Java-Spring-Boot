package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Car;
import com.example.demo.service.CarService;

@RestController
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/available-cars")
    public List<Car> getAvailableCars() {
        return carService.getAvailableCars();
    }
}
