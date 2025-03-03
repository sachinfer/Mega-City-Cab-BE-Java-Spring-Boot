package com.example.demo.controller;

import com.example.demo.model.Booking;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    // Endpoint to get available orders
    @GetMapping("/available-orders")
    public List<Booking> getAvailableOrders() {
        return orderService.getAvailableOrders();  // Delegates the call to the service layer
    }
}
