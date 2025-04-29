package com.example.tripplanner.service;

import java.util.List;

import com.example.tripplanner.model.BankServer;


public interface BankServerService {
	
	 public BankServer saveDetails(BankServer bankServer);

	 public BankServer findByCardCvv(Long cCardnumber, Integer cCvvnumber, String expiryDate);
	 
	 public BankServer getDetailsById(int id);
	 public List<BankServer> getAllDetails();
	 
	 public void removerBankDetailsById(int id);
	BankServer findByUpi(String cUpi);

}
