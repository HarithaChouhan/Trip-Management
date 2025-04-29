package com.example.tripplanner.serviceimpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.tripplanner.model.Payment;
import com.example.tripplanner.repository.PaymentRepository;
import com.example.tripplanner.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }
    @Override
    public Payment getPaymentById(Long paymentId) {
        Optional<Payment> optionalPayment = paymentRepository.findById(paymentId);
        return optionalPayment.orElseThrow(() ->
            new RuntimeException("Payment not found with id: " + paymentId)
        );
    }

    @Override
    public List<Payment> getAllPayments() { 
        return paymentRepository.findAll();
    }

    @Override
    public Payment updatePayment(Long paymentId, Payment updated) {
        Optional<Payment> optional = paymentRepository.findById(paymentId);
        if (optional.isPresent()) {
            Payment existing = optional.get();
            existing.setPaymentDateAndTime(updated.getPaymentDateAndTime());
            existing.setPaymentMethod(updated.getPaymentMethod());
            existing.setTotalAmount(updated.getTotalAmount());
            existing.setStatus(updated.getStatus());
            return paymentRepository.save(existing);
        }
        return null;
    }

    @Override
    public void deletePayment(Long paymentId) {
        Payment payment = getPaymentById(paymentId);
        paymentRepository.delete(payment);
    }
}