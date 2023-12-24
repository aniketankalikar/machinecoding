package models;

import enums.Language;
import enums.MovieFeature;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movie extends  BaseModel{

    private String name;
    private Double rating;

    @OneToMany(mappedBy = "movie")
    private List<Show> shows = new ArrayList<>();

    @Enumerated
    @ElementCollection
    private List<Language> languages = new ArrayList<>();

    @ElementCollection
    @Enumerated
    private List<MovieFeature> features = new ArrayList<>();



}
