package com.example.AlacritiPactice01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.example.AlacritiPactice01.CustomerInterface.CustomerInterface;
import com.example.AlacritiPactice01.CustomerRepository.CustomerFakeRepository;
import com.example.AlacritiPactice01.CustomerRepository.CustomerRepository;

@Configuration
public class CustomerConfiguration {

	@Value("${app.useFakeRepo:false}")
	private Boolean useFakeRepo;
	
	@Value("${info.company.name}")
	private String companyName;
	
	@Autowired
	private Environment environment;
	
	@Bean
	CommandLineRunner commandLineRunner(InfoApp infoApp) {
		return args->{
		System.out.println("Command Line runnner");	
		System.out.println(companyName);
		System.out.println( environment.getProperty("info.company.name"));
		System.out.println(infoApp);
		};
	}
	@Bean
	CustomerInterface customerInterface() {
		System.out.println("Use FakeRepo :"+ useFakeRepo);
		return useFakeRepo?
				new CustomerFakeRepository():
					new CustomerRepository();
	}
	
}
