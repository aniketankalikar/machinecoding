package com.example.bookmyshow.model;

import com.example.bookmyshow.enums.Language;
import com.example.bookmyshow.enums.MovieFeature;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
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
@Builder
public class Movie extends BaseModel{

    private String name;
    private Double rating;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated
    private List<Language> languages = new ArrayList<>();

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated
    private List<MovieFeature> features = new ArrayList<>();


}
