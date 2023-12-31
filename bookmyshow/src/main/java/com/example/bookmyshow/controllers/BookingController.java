package com.example.bookmyshow.controllers;


import com.example.bookmyshow.dtos.BookingRequestDTO;
import com.example.bookmyshow.model.Booking;
import com.example.bookmyshow.services.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/booking")
public class BookingController {

    private BookingService bookingService;

    @PostMapping("/create")
    private BookingRequestDTO createBooking(@RequestBody BookingRequestDTO request)
    {

        bookingService.createBooking(request);
        return request;
    }
}
