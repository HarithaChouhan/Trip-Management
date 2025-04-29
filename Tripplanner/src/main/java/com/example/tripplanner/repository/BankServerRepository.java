package com.example.tripplanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.tripplanner.model.BankServer;


public interface BankServerRepository extends JpaRepository<BankServer,Integer>{

	@Query(value = "SELECT * FROM bank_server b WHERE b.c_cardnumber = ?1 AND b.c_cvvnumber = ?2 AND b.expiry_Date LIKE CONCAT(?3, '%')", nativeQuery = true)
	public BankServer findByCardCvv(Long cCardnumber, Integer cCvvnumber, String expiryDate);


	@Query(value = "select * from bank_server b where b.c_upi=?1",nativeQuery = true)
	public BankServer findByUpi(String cUpi);
}
