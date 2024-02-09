package dev.kush.countrycity.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import static jakarta.persistence.CascadeType.*;
import static jakarta.persistence.CascadeType.PERSIST;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class City {

    @Id  @GeneratedValue
    private Long cityId;
    private String cityName;

    @JsonIgnore
    @ManyToOne(cascade = {DETACH,REFRESH,MERGE,PERSIST})
    @JoinColumn(name = "state_id")
    private State state;

    public City(String cityName) {
        this.cityName = cityName;
    }

    public City(String cityName, State state) {
        this.cityName = cityName;
        this.state = state;
    }
}
