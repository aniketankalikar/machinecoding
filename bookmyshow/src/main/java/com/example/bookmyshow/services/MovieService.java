package com.example.bookmyshow.services;

import com.example.bookmyshow.model.Movie;
import com.example.bookmyshow.repositories.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class MovieService {

    private MovieRepository movieRepository;
    public Movie createMovie(Movie movie) {

        return movieRepository.save(movie);
    }

    public Movie getMovie(Long id) {

        return movieRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Movie Not Found "+id)) ;
    }
}
