package com.example.springbootmysql.controllers;


import com.example.springbootmysql.dtos.UserDTO;
import com.example.springbootmysql.model.User;
import com.example.springbootmysql.repositories.UserRepository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    @PostMapping(path = "/add")
    public @ResponseBody String add(@Validated @RequestBody User userRequest)
    {
        User user = new User();
        user.setName(userRequest.getName());
        user.setEmail(userRequest.getEmail());
        userRepository.save(user);
        return "Saved";
    }

    @GetMapping(path = "/all")
    public List<UserDTO> getAllUsers()
    {

        List<User> users = (List<User>) userRepository.findAll();

        List<UserDTO> usersDTOLIst = users.stream().map(p->new UserDTO(p.getId(),p.getName(),p.getEmail())).collect(Collectors.toList());

        return usersDTOLIst;
    }
}