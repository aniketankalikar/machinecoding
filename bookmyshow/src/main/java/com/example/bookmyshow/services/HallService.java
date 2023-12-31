package com.example.bookmyshow.services;

import com.example.bookmyshow.dtos.HallRequest;
import com.example.bookmyshow.dtos.SeatPosition;
import com.example.bookmyshow.enums.SeatType;
import com.example.bookmyshow.model.Hall;
import com.example.bookmyshow.model.Seat;
import com.example.bookmyshow.repositories.HallRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class HallService {

    private SeatService seatService;

    private HallRepository hallRepository;

    public Hall getHall(Long id) {
        return hallRepository.findById(id).orElse(null);
    }

    public Hall createHall(HallRequest request) {
        Hall hall = Hall.builder().name(request.getName())
                .features(request.getFeatures())
                .build();

        hall = hallRepository.save(hall);
        List<Seat> seats = toSeats(hall, request.getSeatRanges());
        if(!CollectionUtils.isEmpty(seats))
        {
            List<Seat> savedSeats = seatService.saveAll(seats);
        }
        return hall;
    }

    public static List<Seat> toSeats(Hall hall, Map<SeatType, List<SeatPosition>> seatPositions) {

        return seatPositions.entrySet().stream().flatMap(entry -> {

            SeatType seatType = entry.getKey();
            List<SeatPosition> positions = entry.getValue();

            return positions
                    .stream()
                    .map(seatPosition ->
                            Seat.builder()
                                    .seatType(seatType)
                                    .rowNo(seatPosition.getRowNo())
                                    .columnNo(seatPosition.getColumnNo())
                                    .hall(hall)
                                    .build());
        }).toList();
    }
}