package models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="shows")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Show extends BaseModel {

    @ManyToOne
    @JoinColumn(name="movie_id")
    private Movie movie;

    private Date startTime;
    private Integer duration;

    @ManyToOne
    private Hall hall;

    @OneToMany(mappedBy = "show")
    private List<ShowSeat> showSeats = new ArrayList<>();
}