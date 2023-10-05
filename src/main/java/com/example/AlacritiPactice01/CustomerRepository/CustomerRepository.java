package com.example.AlacritiPactice01.CustomerRepository;

import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.AlacritiPactice01.CustomerInterface.CustomerInterface;
import com.example.AlacritiPactice01.Entity.Customer;

@Repository
public class CustomerRepository implements CustomerInterface{

	@Override
	public List<Customer> getCustomer() {
		// TODO Auto-generated method stub
		return Collections.singletonList(
				new Customer(1L,"to","be","connected@soon.com")
				);
	}

}
