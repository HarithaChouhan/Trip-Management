package com.example.tripplanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tripplanner.model.Tourist;

public interface TouristRepository extends JpaRepository<Tourist,Integer>{

}
