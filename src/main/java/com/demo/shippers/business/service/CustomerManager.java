package com.demo.shippers.business.service;

import com.demo.shippers.business.requests.CreateCustomerRequest;
import com.demo.shippers.business.responses.CreatedCustomerResponse;
import com.demo.shippers.dataAccess.CustomerRepository;
import com.demo.shippers.entities.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerManager {
    private final CustomerRepository repository;

    public CustomerManager(CustomerRepository repository) {
        this.repository = repository;
    }
    public CreatedCustomerResponse add(CreateCustomerRequest request){
        Customer customer=new Customer.Builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .number(request.getNumber())
                .build();
        customer=repository.save(customer);
      return new CreatedCustomerResponse(customer.getId());
    }
}
