package com.example.bookmyshow.services;

import com.example.bookmyshow.dtos.BookingRequestDTO;
import com.example.bookmyshow.enums.BookingStatus;
import com.example.bookmyshow.enums.SeatStatus;
import com.example.bookmyshow.model.Booking;
import com.example.bookmyshow.model.Customer;
import com.example.bookmyshow.model.Show;
import com.example.bookmyshow.model.ShowSeat;
import com.example.bookmyshow.pricingstrategy.PricingStrategy;
import com.example.bookmyshow.repositories.BookingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.security.InvalidParameterException;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BookingService {

    private BookingRepository bookingRepository;
    private CustomerService customerService;
    private ShowService showService;
    private ShowSeatService showSeatService;

    private PricingStrategy pricingStrategy;

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking createBooking(BookingRequestDTO request) {

        Customer customer= customerService.getCustomerInternal(request.getCustomerId());
        if(customer  ==null)
        {
            throw new NoSuchElementException("Invalid user id "+request.getCustomerId());
        }

        Show show = showService.getShow(request.getShowId());

        if(show  ==null)
        {
            throw new NoSuchElementException("Invalid show id "+request.getShowId());
        }

        List<ShowSeat> showSeats = showSeatService.getShowSeats(request.getShowSeatIds());
        for (ShowSeat showSeat:showSeats)
        {
            if (showSeat.getStatus() != SeatStatus.AVAILABLE) {
                throw new InvalidParameterException("Seat is not available");
            }
        }

        for(ShowSeat showSeat:showSeats)
        {
            showSeat.setStatus(SeatStatus.LOCKED);
        }

        List<ShowSeat> savedSeats = showSeatService.saveAll(showSeats);

        // Step 7 - Create and save the booking
        Booking booking = Booking.builder()
                .customer(customer)
                .show(show)
                .seats(savedSeats)
                .status(BookingStatus.PENDING)
                .bookedAt(new Date())
                .build();

        Double amount = pricingStrategy.calculatePrice(booking);
        Booking withPrice = booking.toBuilder().amount(amount).build();

        return bookingRepository.save(withPrice);
    }
}
