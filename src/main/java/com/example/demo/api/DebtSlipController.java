package com.example.demo.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entities.Customer;
import com.example.demo.entities.DebtSlip;
import com.example.demo.entities.User;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.DebtSlipRepository;
import com.example.demo.repository.UserRepository;

@RestController
@RequestMapping(path = "/debtslip", produces = "application/json")
@CrossOrigin(origins = "*")
public class DebtSlipController {
	@Autowired
	private DebtSlipRepository repository;
	
	public DebtSlipController(DebtSlipRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping
	public Iterable<DebtSlip> findAll() {
		return repository.findAll();
	}
	@GetMapping("/{id}")
	public DebtSlip findById(@PathVariable("id") int id) {
		Optional<DebtSlip> customer=repository.findById(id);
		if(customer.isPresent()) {
			return customer.get();
		}
		return null;
	}
	@GetMapping("IDCustomer/{id}")
	public DebtSlip getByIDCustomer(@PathVariable("id") int id) {
		Iterable<DebtSlip> debtslips = repository.findAll();
		DebtSlip tmp = new DebtSlip();
		for (DebtSlip debtSlip : debtslips) {
			if(id == debtSlip.getIDCustomer()) tmp = debtSlip;
		}
		return tmp;
	}
}
