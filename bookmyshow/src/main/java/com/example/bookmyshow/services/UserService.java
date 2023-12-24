package com.example.bookmyshow.services;

import com.example.bookmyshow.model.User;
import com.example.bookmyshow.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public User createUser(String userName, String password)
    {
        User user = new User(userName,password);
        return userRepository.save(user);
    }
}
