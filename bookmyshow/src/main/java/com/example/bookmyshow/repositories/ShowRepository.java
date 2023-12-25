package com.example.bookmyshow.repositories;

import com.example.bookmyshow.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<Show, Long> {
}
