package com.example.tripplanner.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tripplanner.model.BankServer;
import com.example.tripplanner.repository.BankServerRepository;
import com.example.tripplanner.service.BankServerService;

@Service
public class BankServerServiceImpl implements BankServerService{
	
	@Autowired
	private BankServerRepository bankserverRepositry;
	
	@Override
	public BankServer saveDetails(BankServer bankServer) {
		
		return bankserverRepositry.save(bankServer);
	}
	@Override
	public BankServer findByCardCvv(Long cCardnumber, Integer cCvvnumber,String expiryDate) {
		return bankserverRepositry.findByCardCvv(cCardnumber, cCvvnumber, expiryDate);
	}
	
	@Override
	public BankServer findByUpi(String cUpi) {
		
		return bankserverRepositry.findByUpi(cUpi);
	}
	@Override
	public BankServer getDetailsById(int id) {
		// TODO Auto-generated method stub
		return bankserverRepositry.findById(id).get();
	}
	@Override
	public void removerBankDetailsById(int id) {
		// TODO Auto-generated method stub
		
		BankServer bs=getDetailsById(id);
	bankserverRepositry.deleteById(id);;
	}
	@Override
	public List<BankServer> getAllDetails() {
		// TODO Auto-generated method stub
		return bankserverRepositry.findAll();
	}

}
