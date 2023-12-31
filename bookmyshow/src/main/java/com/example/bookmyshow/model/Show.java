package com.example.bookmyshow.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "shows")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Show extends BaseModel{

    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;

    private Integer duration;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "hall_id")
    private Hall hall;

    @OneToMany(mappedBy = "show", fetch = FetchType.EAGER)
    private List<ShowSeat> showSeats = new ArrayList<>();

    public String toString()
    {
        return "";
    }

}
