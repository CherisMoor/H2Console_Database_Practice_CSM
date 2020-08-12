package com.tts.h2explore;

import com.tts.h2explore.Domain.Customer;
import com.tts.h2explore.Repository.CustomerRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CustomerRepository repository) {
		repository.save(new Customer("Rickey", "McTester"));
		repository.save(new Customer("Sally", "Doe"));
		repository.save(new Customer("James", "Brown"));
		repository.save(new Customer("Michael", "Jones"));
		repository.save(new Customer("Prince", "Rodgers"));
		repository.save(new Customer("Rick", "James"));

		log.info("Customers added to table");
		log.info("========================");
		for (Customer customer : repository.findAll()) {
			log.info(customer.toString());
		}

		log.info("");

		repository.findById(1L).ifPresent(customer -> {
			log.info("Customer found using findById");
			log.info("=============================");
			log.info(customer.toString());
			log.info("");
		});

		log.info("Customer found using findByLastName");
		log.info("===================================");
		repository.findByLastName("Brown").forEach(cust -> {
			log.info(cust.toString());
		});

		log.info("The End");

		return;
	}

}
