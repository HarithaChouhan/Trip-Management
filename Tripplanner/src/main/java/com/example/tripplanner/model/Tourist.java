package com.example.tripplanner.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Tourist")
public class Tourist {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Toursit_id")
	private int tId;
	
	@Column(name="first_name")
	private String tFirstName;
	
	@Column(name="last_name")
	private String tLastName;
	
	@Column(name="email")
	private String tEmail;
	
	@Column(name="Mobile_No")
	private String tMobileNo;
	
	
	@Column(name="Age")
	private int tAge;
	
	@Column(name="Gender")
	private String tGender;
	
	
	@ManyToOne
	@JsonManagedReference
	@JoinColumn(name="trip_id")
	private Trip trip;
	
	@Column(name="Payment_Id")
	private String paymentId;
	
	public int gettId() {
		return tId;
	}

	public void settId(int tId) {
		this.tId = tId;
	}

	public String gettFirstName() {
		return tFirstName;
	}

	public void settFirstName(String tFirstName) {
		this.tFirstName = tFirstName;
	}

	public String gettLastName() {
		return tLastName;
	}

	public void settLastName(String tLastName) {
		this.tLastName = tLastName;
	}

	public String gettEmail() {
		return tEmail;
	}

	public void settEmail(String tEmail) {
		this.tEmail = tEmail;
	}

	public String gettMobileNo() {
		return tMobileNo;
	}

	public void settMobileNo(String tMobileNo) {
		this.tMobileNo = tMobileNo;
	}

	public int gettAge() {
		return tAge;
	}

	public void settAge(int tAge) {
		this.tAge = tAge;
	}

	public String gettGender() {
		return tGender;
	}

	public void settGender(String tGender) {
		this.tGender = tGender;
	}

	public Trip getTrip() {
		return trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	
	

}
