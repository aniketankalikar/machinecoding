package com.example.bookmyshow.repositories;

import com.example.bookmyshow.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {

    public List<Seat> findAllByHallId(Long id);
}
