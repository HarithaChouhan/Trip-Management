package com.example.tripplanner.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tripplanner.model.BankServer;
import com.example.tripplanner.service.BankServerService;


@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api/Bankserver")
public class BankServerController {
	
	@Autowired
	private BankServerService bankServerService;
	
	@PostMapping("/savebank")
	public BankServer saveDetails(@RequestBody BankServer bankserver) {
		return bankServerService.saveDetails(bankserver);
		
	}
	
	
	//find by card
	@GetMapping("/findcardnumcvv/{cnum}/{cvv}/{date}")
	public BankServer findByCardCvv(@PathVariable("cnum") Long cCardnumber,@PathVariable("cvv") Integer cCvvnumber,@PathVariable("date") String expiryDate) {
		return bankServerService.findByCardCvv(cCardnumber,cCvvnumber,expiryDate);
	
		
	}
	@GetMapping("/findById/{id}")
	public BankServer getDetailsById(@PathVariable("id") int id) {
		return bankServerService.getDetailsById(id);
	}
	//find by upi
	@GetMapping("/findbyupi/{upi}")
	public BankServer findByUpi(@PathVariable("upi") String cUpi) {
		return bankServerService.findByUpi(cUpi);
	}
	
	@GetMapping
	public List<BankServer> getAllDetails(){
		return bankServerService.getAllDetails();
	}
	
	@DeleteMapping("getalldetailsafterdeleting/{id}")
	public List<BankServer> getBankDetailsAfterDeleting(@PathVariable("id") int id) {
		bankServerService.removerBankDetailsById(id);
		return bankServerService.getAllDetails();
		
	}
	

}
