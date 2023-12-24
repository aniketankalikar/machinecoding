package models;

import enums.SeatType;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Seat extends BaseModel{

    private Integer rowNo;
    private Integer colNo;

    @Enumerated
    private SeatType seatType;

    @ManyToOne
    @JoinColumn(name="hall_id")
    private Hall hall;
}
