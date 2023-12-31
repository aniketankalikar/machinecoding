package com.example.bookmyshow.controllers;

import com.example.bookmyshow.dtos.CustomerDTO;
import com.example.bookmyshow.exceptions.InvalidCustomerException;
import com.example.bookmyshow.model.Customer;
import com.example.bookmyshow.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@AllArgsConstructor
public class CustomerController {

    private CustomerService customerService;

    @PostMapping("/add")
    public Customer createCustomer(@RequestBody CustomerDTO request)
    {
        validate(request);
        return customerService.createCustomer(request);
    }

    private void validate(CustomerDTO request) {
        if(!StringUtils.hasLength(request.getEmail()) )
            throw new InvalidCustomerException();
    }

    @GetMapping("/fetch/{id}")
    public Customer getCustomer(@PathVariable Long id) {
        return customerService.getCustomer(id);
    }
}
