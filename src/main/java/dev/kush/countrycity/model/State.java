package dev.kush.countrycity.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class State {

    @Id   @GeneratedValue
    private Long stateId;
    private String stateName;
    private String capital;

    @JsonIgnore
    @ManyToOne(cascade = {DETACH,REFRESH,MERGE,PERSIST})
    @JoinColumn(name = "country_id")
    private Country country;

    @JsonIgnore
    @OneToMany(mappedBy = "state", cascade = ALL)
    private List<City> cities;

    public State(String stateName, String capital) {
        this.stateName = stateName;
        this.capital = capital;
    }

    public State(String stateName, String capital, Country country) {
        this.stateName = stateName;
        this.capital = capital;
        this.country = country;
    }

    public State(String stateName, String capital, Country country, List<City> cities) {
        this.stateName = stateName;
        this.capital = capital;
        this.country = country;
        this.cities = cities;
    }
}
