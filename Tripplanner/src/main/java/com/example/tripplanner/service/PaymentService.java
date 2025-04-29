package com.example.tripplanner.service;

import java.util.List;
import com.example.tripplanner.model.Payment;

public interface PaymentService {
    Payment createPayment(Payment payment);
    Payment getPaymentById(Long paymentId);
    List<Payment> getAllPayments();
    Payment updatePayment(Long paymentId, Payment paymentDetails);
    void deletePayment(Long paymentId);
}