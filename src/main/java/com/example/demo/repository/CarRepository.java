package com.example.demo.repository;

import com.example.demo.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

<<<<<<< HEAD
@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
    // You can add custom query methods here if needed
=======
public interface CarRepository extends JpaRepository<Car, Long> {  // Use Long here, not Integer

    // Custom query to find cars by status
    List<Car> findByStatus(String status);  // This will return all cars with the given status
>>>>>>> 172ed910c6ce040bca5a2a2109e859a28d3b9cac
}
