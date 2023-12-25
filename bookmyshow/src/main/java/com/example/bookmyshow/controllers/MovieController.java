package com.example.bookmyshow.controllers;

import com.example.bookmyshow.dtos.MovieRequestDTO;
import com.example.bookmyshow.model.Movie;
import com.example.bookmyshow.services.MovieService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movie")
@AllArgsConstructor
public class MovieController {

    private MovieService movieService;

    @PostMapping("/create")
    public Movie createMovie(@RequestBody MovieRequestDTO request)
    {
        return movieService.createMovie(request.toMovie());
    }

    @GetMapping("/{id}")
    public Movie getMovie(@PathVariable Long id)
    {
        return movieService.getMovie(id);
    }
}
