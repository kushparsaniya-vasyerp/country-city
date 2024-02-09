package dev.kush.countrycity.config;

import dev.kush.countrycity.model.City;
import dev.kush.countrycity.model.Country;
import dev.kush.countrycity.model.State;
import dev.kush.countrycity.repository.CityRepository;
import dev.kush.countrycity.repository.CountryRepository;
import dev.kush.countrycity.repository.StateRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SampleData {

    @Bean
    CommandLineRunner commandLineRunner(
            CountryRepository countryRepository,
            StateRepository stateRepository,
            CityRepository cityRepository
    ){
        return args -> {
            Country country = new Country("India","new delhi");

            State state1 = new State("Gujarat","gandhinagar",country);
            State state2 = new State("Maharastra","mumbai",country);

            country.setStates(List.of(state1, state2));

            City city1 = new City("Junagadh",state1);
            City city2 = new City("Rajkot",state1);

            City city3 = new City("pune",state2);
            City city4 = new City("nasik",state2);

            state1.setCities(List.of(city1,city2));
            state2.setCities(List.of(city3,city4));
            countryRepository.save(country);
            stateRepository.saveAll(List.of(state1,state2));
            cityRepository.saveAll(List.of(city1,city2,city3,city4));
        };
    }
}
