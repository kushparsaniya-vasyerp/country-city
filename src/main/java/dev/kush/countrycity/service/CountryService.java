package dev.kush.countrycity.service;


import dev.kush.countrycity.model.Country;

import java.util.List;


public interface CountryService {
    List<Country> findAllCountries();
    Country findByCountryId(Long countryId);
    Country saveCountry(Country country);
    Country deleteCountry(Long countryId);
}
