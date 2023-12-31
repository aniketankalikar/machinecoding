package com.example.bookmyshow.controllers;

import com.example.bookmyshow.dtos.HallRequest;
import com.example.bookmyshow.model.Hall;
import com.example.bookmyshow.services.HallService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hall")
@AllArgsConstructor
public class HallController {

    private HallService hallService;

    @PostMapping("/create")
    public Hall create(@RequestBody HallRequest request)
    {
        Hall hall = hallService.createHall(request);
        return hall;
    }
}
