package com.example.AlacritiPactice01.CustomerRepository;

import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.AlacritiPactice01.CustomerInterface.CustomerInterface;
import com.example.AlacritiPactice01.Entity.Customer;

public class CustomerFakeRepository implements CustomerInterface{

	@Override
	public List<Customer> getCustomer() {
		// TODO Auto-generated method stub
		return Arrays.asList(
				new Customer(1L,"rcr","rcr@1309","rcr@gmail.com"),
				new Customer(2L,"rrr","rrr@1008","rrr@gmail.com")
				);
	}

}
