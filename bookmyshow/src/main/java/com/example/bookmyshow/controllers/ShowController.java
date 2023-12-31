package com.example.bookmyshow.controllers;


import com.example.bookmyshow.dtos.ShowRequest;
import com.example.bookmyshow.model.Show;
import com.example.bookmyshow.services.ShowService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class ShowController {

    private ShowService showService;

    @GetMapping("/show/{id}")
    public Show readShow(@PathVariable Long id)
    {
        return showService.getShow(id);

    }

    @PostMapping("/show/add")
    public ShowRequest createShow(@RequestBody ShowRequest request)
    {
        showService.createShow(request);
        return request;
    }

}
