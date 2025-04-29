package com.example.tripplanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.tripplanner.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}