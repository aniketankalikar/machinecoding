package com.example.bookmyshow.dtos;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class SeatPosition {

    private Integer rowNo;
    private Integer columnNo;
}
