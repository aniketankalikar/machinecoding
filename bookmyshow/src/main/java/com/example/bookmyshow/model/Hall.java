package com.example.bookmyshow.model;

import com.example.bookmyshow.enums.MovieFeature;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Hall extends BaseModel{

    private String name;

    @OneToMany(mappedBy = "hall", fetch = FetchType.EAGER)
    private List<Seat> seats = new ArrayList<>();

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated
    private List<MovieFeature> features = new ArrayList<>();

    public String toString()
    {
        return "";
    }
}
