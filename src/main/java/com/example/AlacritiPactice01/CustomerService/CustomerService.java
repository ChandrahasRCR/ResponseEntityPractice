package com.example.AlacritiPactice01.CustomerService;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.AlacritiPactice01.CustomerExceptions.NotFoundException;
import com.example.AlacritiPactice01.CustomerInterface.CustomerInterface;
import com.example.AlacritiPactice01.Entity.Customer;

@Service
public class CustomerService {
	private final static Logger LOGGER =
			LoggerFactory.getLogger(CustomerService.class);
	
	private CustomerInterface customerInterface;
	
	
	@Autowired
	public CustomerService( CustomerInterface customerInterface) {
		this.customerInterface = customerInterface;
	}



	public List<Customer> getCustomer() {
//		return new Customer(1L,"rcr","rcr@1309","rcr@gmail.com");
		LOGGER.info("Fetching All Customers");	
		return customerInterface.getCustomer();
	}
	public Customer getCustomer(Long id) {
		return getCustomer()
				.stream()
				.filter(customer->customer.getId().equals(id))
				.findFirst()
				.orElseThrow(() -> {
					NotFoundException notFoundException =new NotFoundException(
							"Customer with id= "+id+" not found");
					
					LOGGER.error("Error getting Customer with {}",id, notFoundException);
					return notFoundException;
					});
	}

}
