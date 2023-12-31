package com.example.bookmyshow.pricingstrategy;

import com.example.bookmyshow.enums.SeatType;
import com.example.bookmyshow.model.Booking;
import com.example.bookmyshow.model.ShowSeat;
import org.springframework.stereotype.Component;

@Component
public class SeatBasedPricingStrategy implements PricingStrategy {
    @Override
    public Double calculatePrice(Booking booking) {
        return booking.getSeats().stream().mapToDouble(SeatBasedPricingStrategy::calculatePrice).sum();
    }

    private static Double calculatePrice(ShowSeat seat) {
        return getPrice(seat.getSeat().getSeatType());
    }

    private static Double getPrice(SeatType seatType) {
        switch (seatType) {
            case VIP -> {
                return 2000.0;
            }
            case PLATINUM -> {
                return 1000.0;
            }
            case GOLD -> {
                return 500.0;
            }
            case SILVER -> {
                return 200.0;
            }
        }
        throw new IllegalArgumentException("Seat Type not valid " + seatType);
    }
}
