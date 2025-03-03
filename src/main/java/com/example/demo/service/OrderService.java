package com.example.demo.service;

import com.example.demo.model.Booking;
import com.example.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    // Get available cars from the database
    public List<Booking> getAvailableOrders() {
        return orderRepository.findByStatus("pending");  // Query repository for cars with status 'pending'
    }
}
