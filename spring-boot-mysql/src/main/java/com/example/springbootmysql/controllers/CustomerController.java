package com.example.springbootmysql.controllers;


import com.example.springbootmysql.dtos.CustomerDTO;
import com.example.springbootmysql.model.Cust;
import com.example.springbootmysql.repositories.CustomerRepository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/customer")
public class CustomerController {

    private CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository)
    {
        this.customerRepository = customerRepository;
    }

    @PostMapping(path = "/add")
    public @ResponseBody String add(@Validated @RequestBody Cust userRequest)
    {
        Cust customer = new Cust();
        customer.setName(userRequest.getName());
        customer.setEmail(userRequest.getEmail());
        customerRepository.save(customer);
        return "Saved";
    }

    @GetMapping(path = "/all")
    public List<CustomerDTO> getAllCustomers()
    {

        List<Cust> customers = (List<Cust>) customerRepository.findAll();

        List<CustomerDTO> customerDTOLIst = customers.stream().map(p->new CustomerDTO(p.getId(),p.getName(),p.getEmail())).collect(Collectors.toList());

        return customerDTOLIst;
    }
}