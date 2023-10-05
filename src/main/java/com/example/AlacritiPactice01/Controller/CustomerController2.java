package com.example.AlacritiPactice01.Controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.AlacritiPactice01.CustomerService.CustomerService;
import com.example.AlacritiPactice01.Entity.Customer;

@RestController
@RequestMapping("/v2")
public class CustomerController2 {
	
	private CustomerService customerservice;
	
	
	@Autowired
	public CustomerController2(CustomerService customerservice) {
		this.customerservice = customerservice;
	}



	@GetMapping("/customer")
	public List<Customer> getCustomer() {
//		return new Customer(1L,"rcr","rcr@1309","rcr@gmail.com");
	return Arrays.asList(
			new Customer(1L,"v2","vr","v2@gmail.com")
			);
	}
	
	@PostMapping("/customer")
	public void createCustomer(@RequestBody Customer customer) {
		System.out.println("post "+customer);
	}
	
	@PutMapping("/customer")
	public void updateCustomer(@RequestBody Customer customer) {
		System.out.println("put "+customer);
	}
	
	
	@DeleteMapping("/customer/{id}")
	public void deleteCustomer(@PathVariable("id") Long id ) {
		System.out.println("the Customer with id="+id+" id deleted");
	}
	
}