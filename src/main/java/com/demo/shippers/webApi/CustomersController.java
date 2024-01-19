package com.demo.shippers.webApi;

import com.demo.shippers.business.requests.CreateCustomerRequest;
import com.demo.shippers.business.responses.CreatedCustomerResponse;
import com.demo.shippers.business.service.CustomerManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/api/customers")
public class CustomersController {
    private final CustomerManager manager;

    public CustomersController(CustomerManager manager) {
        this.manager = manager;
    }
    @PostMapping("add")
    public CreatedCustomerResponse add(@RequestBody CreateCustomerRequest request){
        return manager.add(request);
    }
}
