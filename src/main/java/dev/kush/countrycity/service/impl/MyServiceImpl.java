package dev.kush.countrycity.service.impl;

import dev.kush.countrycity.exception.ItemNotFoundException;
import dev.kush.countrycity.model.City;
import dev.kush.countrycity.model.Country;
import dev.kush.countrycity.model.State;
import dev.kush.countrycity.repository.CityRepository;
import dev.kush.countrycity.repository.CountryRepository;
import dev.kush.countrycity.repository.StateRepository;
import dev.kush.countrycity.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyServiceImpl implements MyService {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private CityRepository cityRepository;



    @Override
    public List<Country> getCountryList() {
        return countryRepository.findAll();
    }

    @Override
    public List<State> getStateList(String countryName) {
        Country country = countryRepository.findByCountryName(countryName).orElseThrow(
                () -> new ItemNotFoundException("Country not found with name " + countryName)
        );
        return stateRepository.getStatesByCountryId(country.getCountryId());
    }

    @Override
    public List<City> getCityList(String stateName) {
        State state = stateRepository.findByStateName(stateName).orElseThrow(
                () -> new ItemNotFoundException("State not found with name " + stateName)
        );
        return cityRepository.getCitiesByStateId(state.getStateId());
    }
}
