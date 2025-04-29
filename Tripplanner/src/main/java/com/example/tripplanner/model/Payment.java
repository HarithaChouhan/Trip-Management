package com.example.tripplanner.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="payment_id")
    private Long paymentId;
    
    @Column(name="payment_date")
    private LocalDateTime paymentDateAndTime;
    
    @Column(name="payment_method")
    private String paymentMethod;
    
    @Column(name="total_amount")
    private BigDecimal totalAmount;
    
    @Column(name="status")
    private String status;
    
    public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

    public LocalDateTime getPaymentDateAndTime() {
		return paymentDateAndTime;
	}

	public void setPaymentDateAndTime(LocalDateTime paymentDateAndTime) {
		this.paymentDateAndTime = paymentDateAndTime;
	}

	public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}