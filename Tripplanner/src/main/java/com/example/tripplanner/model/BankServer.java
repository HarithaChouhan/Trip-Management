package com.example.tripplanner.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Bank_server")
public class BankServer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true)
	private Integer id;
	
	@Column(name="c_cardnumber",unique = true)
	private Long cCardnumber;
	
	@Column(name="c_cvvnumber",unique = true)
	private Integer cCvvnumber;
	
	@Column(name="c_upi")
	private String cUpi;
	
	@Column(name="expiry_Date")
	private Date expiryDate ;
	
	public BankServer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BankServer(Long cCardnumber, Integer cCvvnumber, String cUpi, Date expiryDate) {
		super();
		this.cCardnumber = cCardnumber;
		this.cCvvnumber = cCvvnumber;
		this.cUpi = cUpi;
		this.expiryDate = expiryDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getcCardnumber() {
		return cCardnumber;
	}

	public void setcCardnumber(Long cCardnumber) {
		this.cCardnumber = cCardnumber;
	}

	public Integer getcCvvnumber() {
		return cCvvnumber;
	}

	public void setcCvvnumber(Integer cCvvnumber) {
		this.cCvvnumber = cCvvnumber;
	}

	public String getcUpi() {
		return cUpi;
	}

	public void setcUpi(String cUpi) {
		this.cUpi = cUpi;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	@Override
	public String toString() {
		return "BankServer [id=" + id + ", cCardnumber=" + cCardnumber + ", cCvvnumber=" + cCvvnumber + ", cUpi=" + cUpi
				+ ", expiryDate=" + expiryDate + "]";
	}


}
