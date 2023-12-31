package com.example.bookmyshow.services;

import com.example.bookmyshow.dtos.ShowRequest;
import com.example.bookmyshow.enums.SeatStatus;
import com.example.bookmyshow.model.*;
import com.example.bookmyshow.repositories.ShowRepository;
import com.example.bookmyshow.repositories.ShowSeatRepository;
import lombok.AllArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class ShowService {

    private final ShowSeatRepository showSeatRepository;
    private HallService hallService;
    private ShowRepository showRepository;
    private MovieService movieService;
    private SeatService seatService;

    public Show createShow(ShowRequest request) {



        Hall hall = hallService.getHall(request.getHallId());

        Movie movie = movieService.getMovie(request.getMovieId());

        Show show = Show
                .builder()
                .hall(hall)
                .startTime(request.getStartTime())
                .duration(request.getDuration())
                .movie(movie)
                .build();

        Show savedShow = showRepository.save(show);

        // Task 2
        // Get the seats in the hall using HallId
        // Create the showSeats using the savedShow
        List<Seat> seats = seatService.getAll(request.getHallId());

        List<ShowSeat> showSeats = seats.stream()
                .map(seat ->
                        ShowSeat.builder()
                                .seat(seat)
                                .show(savedShow)
                                .status(SeatStatus.AVAILABLE)
                                .build()
                ).toList();

        // Save the show seats
        showSeatRepository.saveAll(showSeats);
        // Save the show again

        return savedShow;
    }

    public Show getShow(Long id) {
        return showRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Invalid show ID:" + id));
    }
}
