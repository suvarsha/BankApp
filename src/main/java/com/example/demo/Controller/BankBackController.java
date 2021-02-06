package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.training.backendservice.models.Users;
import com.example.demo.dao.BankBackRepository;
import com.example.demo.pojos.BankBack;
@CrossOrigin(origins="*",allowedHeaders="*")
@RestController
@RequestMapping("/BankData")
public class BankBackController {

	@Autowired
	private BankBackRepository bankBackRepository;

	@RequestMapping("/getAllusers")
	public Iterable<BankBack> getAllUser() {
		return bankBackRepository.findAll();
	}

	@PostMapping("/initial")
	public BankBack save(@RequestBody BankBack bankdata) {

		if (bankdata.getOpeningblc() == null) {
			bankdata.setOpeningblc(500);
		} else {
			bankdata.setOpeningblc(bankdata.getOpeningblc());
		}
		
		 // bankdata.setClosingbalance(bankdata.getClosingbalance());
		  bankdata.setDepositorname(bankdata.getDepositorname());
		  bankdata.setDepositornumber(bankdata.getDepositornumber());
		//bankdata.setTranscode(bankdata.getTranscode());
		 bankdata.setAmount(bankdata.getAmount());
		

		System.out.println(bankdata);
		bankdata.setClosingbalance(bankdata.getOpeningblc());
		if (bankdata.getTranscode().equals("d")) {
			int balance = bankdata.getClosingbalance()+ bankdata.getAmount();
			System.out.println(balance);
			bankdata.setClosingbalance(balance);
			bankdata.setTranscode(bankdata.getTranscode());
		
			System.out.println(bankdata);

		} else if (bankdata.getTranscode().equals("w")) {
			if(bankdata.getClosingbalance()>bankdata.getAmount()) {
			int balance = bankdata.getClosingbalance() - bankdata.getAmount();
			System.out.println(balance);
			bankdata.setClosingbalance(balance);
			bankdata.setTranscode(bankdata.getTranscode());
			System.out.println(bankdata);
		}
		
		else {
			System.out.println("you cannot withdraw because your balance is less than withdraw amount");
		
			System.out.println(bankdata);
		}
		}
		bankBackRepository.save(bankdata);
		return bankdata;
	}
	/*
	 * @PostMapping("/transaction") public BankBack Transaction(@RequestBody
	 * BankBack bankdata) {
	 * 
	 * if(bankdata.getTranscode()=="d") { int
	 * amount1=bankdata.getOpeningblc()+bankdata.getAmount();
	 * bankdata.setClosingbalance(amount1);
	 * 
	 * } else if(bankdata.getTranscode()=="w"){ int
	 * amount1=bankdata.getOpeningblc()-bankdata.getAmount();
	 * bankdata.setClosingbalance(amount1); } return bankdata; }
	 */
	@PutMapping("/updating/{depositornumber}")
	public  BankBack updateaccount(@RequestBody BankBack account,@PathVariable("depositornumber") int number) {
		account.setDepositornumber(number);
		System.out.println(account);
		if (account.getTranscode().equals("d")) {
			int balance = account.getClosingbalance()+ account.getAmount();
			System.out.println(balance);
			account.setClosingbalance(balance);
			account.setTranscode(account.getTranscode());
		
			System.out.println(account);

		} else if (account.getTranscode().equals("w")) {
			if(account.getClosingbalance()>account.getAmount()) {
			int balance = account.getClosingbalance() - account.getAmount();
			System.out.println(balance);
			account.setClosingbalance(balance);
			account.setTranscode(account.getTranscode());
			System.out.println(account);
		}
		
		else {
			System.out.println("you cannot withdraw because your balance is less than withdraw amount");
		
			System.out.println(account);
		}
		}
		bankBackRepository.save(account);
		return account;
}
	@GetMapping("/findByUserNameOrPassword/{userName}/{password}")
	public BankBack findAllinOne(@PathVariable("depositornumber") Integer number)
	{
	
	Optional<BankBack> user=BankBackRepository.findById(number);
		return user.get();
	}
}
