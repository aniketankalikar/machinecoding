package com.example.bookmyshow.dtos;

import com.example.bookmyshow.enums.MovieFeature;
import com.example.bookmyshow.enums.SeatType;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Data
public class HallRequest implements Serializable {

   private String name;
    private List<MovieFeature> features = new ArrayList<>();
    private Map<SeatType, List<SeatPosition>> seatRanges = new HashMap<>();


}
