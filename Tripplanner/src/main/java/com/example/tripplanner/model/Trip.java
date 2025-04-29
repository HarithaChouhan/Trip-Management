package com.example.tripplanner.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="trip_id")
    private Long tripId;
    @Column(name="Trip_Type",nullable=false)
    private String trip_type; // public, private, self
    @Column(name="Trip_source",nullable=false)
    private String source;
    @Column(name="Trip_Destination",nullable=false)
    private String destination;
    @Column(name="Trip_Budget",nullable=false)
    private double budget;
    @Column(name="StartDate",nullable=false)
    private LocalDate trip_startDate;
    @Column(name="EndDate",nullable=false)
    private LocalDate trip_endDate;
    @Column(name="transportationMode")
    private String tranportationMode;

    
    
    public String getTranportationMode() {
		return tranportationMode;
	}

	public void setTranportationMode(String tranportationMode) {
		this.tranportationMode = tranportationMode;
	}
	@Column(length = 1000)
    private String description;
    
	public List<Tourist> getTourist() {
		return tourist;
	}

	public void setTourist(List<Tourist> tourist) {
		this.tourist = tourist;
	}
	
	@OneToMany(mappedBy="trip")
	@JsonBackReference
	private List<Tourist> tourist;

    public Long getTripId() {
		return tripId;
	}

	public void setTripId(Long tripId) {
		this.tripId = tripId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

 

	public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }


	public String getTrip_type() {
		return trip_type;
	}

	public void setTrip_type(String trip_type) {
		this.trip_type = trip_type;
	}

	public LocalDate getTrip_startDate() {
		return trip_startDate;
	}

	public void setTrip_startDate(LocalDate trip_startDate) {
		this.trip_startDate = trip_startDate;
	}

	public LocalDate getTrip_endDate() {
		return trip_endDate;
	}

	public void setTrip_endDate(LocalDate trip_endDate) {
		this.trip_endDate = trip_endDate;
	}

}