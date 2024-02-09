package dev.kush.countrycity.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

import static jakarta.persistence.CascadeType.ALL;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Country {

    @Id  @GeneratedValue
    private Long countryId;
    private String countryName;
    private String capital;

    @JsonIgnore
    @OneToMany(mappedBy = "country",cascade = ALL)
    private List<State> states;

    public Country(String countryName, String capital) {
        this.countryName = countryName;
        this.capital = capital;
    }

    public Country(String countryName, String capital, List<State> states) {
        this.countryName = countryName;
        this.capital = capital;
        this.states = states;
    }
}
