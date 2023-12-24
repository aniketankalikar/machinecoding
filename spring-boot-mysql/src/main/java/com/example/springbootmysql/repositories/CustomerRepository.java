package com.example.springbootmysql.repositories;

import com.example.springbootmysql.model.Cust;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Cust,Integer> {
}
