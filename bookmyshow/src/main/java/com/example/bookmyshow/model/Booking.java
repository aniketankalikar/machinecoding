package com.example.bookmyshow.model;

import com.example.bookmyshow.enums.BookingStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Booking extends BaseModel{

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Show show;

    @ManyToMany
    private List<ShowSeat> seats = new ArrayList<>();

    private Double amount;

    private Date bookedAt;

    @Enumerated
    private BookingStatus status;

    @OneToMany
    private List<Payment> payments = new ArrayList<>();
}