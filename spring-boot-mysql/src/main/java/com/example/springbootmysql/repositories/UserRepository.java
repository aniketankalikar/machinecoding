package com.example.springbootmysql.repositories;

import com.example.springbootmysql.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {
}
