package com.example.bookmyshow.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShowRequest implements Serializable {

    private Long hallId;
    private Long movieId;
    private Date startTime;
    private Integer duration;
}
