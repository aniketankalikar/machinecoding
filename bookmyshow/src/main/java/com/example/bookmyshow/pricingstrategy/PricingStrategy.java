package com.example.bookmyshow.pricingstrategy;

import com.example.bookmyshow.model.Booking;

public interface PricingStrategy {
    Double calculatePrice(Booking booking);
}
