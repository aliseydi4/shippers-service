package com.demo.shippers.dataAccess;

import com.demo.shippers.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
