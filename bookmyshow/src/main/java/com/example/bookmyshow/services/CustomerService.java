package com.example.bookmyshow.services;

import com.example.bookmyshow.dtos.CustomerDTO;
import com.example.bookmyshow.exceptions.CustomerNotFoundException;
import com.example.bookmyshow.exceptions.EmailAlreadyExistsException;
import com.example.bookmyshow.model.Customer;
import com.example.bookmyshow.model.User;
import com.example.bookmyshow.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerService {

    private CustomerRepository customerRepository;
    private UserService userService;

    public Customer getCustomer(Long custId)
    {
        return customerRepository.findById(custId).orElseThrow(() -> new CustomerNotFoundException(custId));
    }
    public Customer getCustomerInternal(Long userId) {
        return customerRepository.findById(userId).orElse(null);
    }

    public Customer createCustomer(CustomerDTO request)
    {
        String email = request.getEmail();
        Optional<Customer> existingCustomer  = customerRepository.findByEmail(email);
        if(existingCustomer.isPresent())
        {
            throw new EmailAlreadyExistsException(email);
        }

        User user = userService.createUser(request.getUsername(),request.getPassword());

        Customer customer = Customer.builder().city(request.getCity()).email(request.getEmail()).phoneNumber(request.getPhoneNumber()).fullName(request.getFullName()).user(user).build();
        return customerRepository.save(customer);

    }

}