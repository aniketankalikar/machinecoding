package com.example.bookmyshow.dtos;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Data
public class BookingRequestDTO {

    private Long customerId;
    private Long showId;
    private List<Long> showSeatIds = new ArrayList<>();
}
