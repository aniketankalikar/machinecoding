package com.example.springbootmysql.repositories;

import com.example.springbootmysql.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer,Integer> {
}
