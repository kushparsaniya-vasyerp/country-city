package dev.kush.countrycity.service;

import dev.kush.countrycity.model.City;
import dev.kush.countrycity.model.Country;
import dev.kush.countrycity.model.State;

import java.util.List;

public interface MyService {
    List<Country> getCountryList();

    List<State> getStateList(String countryName);

    List<City> getCityList(String stateName);
}
