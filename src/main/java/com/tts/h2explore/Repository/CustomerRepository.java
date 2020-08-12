package com.tts.h2explore.Repository;

import org.springframework.data.repository.CrudRepository;
import java.util.List;
import com.tts.h2explore.Domain.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);
}