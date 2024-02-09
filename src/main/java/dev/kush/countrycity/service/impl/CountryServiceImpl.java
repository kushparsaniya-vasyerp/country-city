package dev.kush.countrycity.service.impl;

import dev.kush.countrycity.exception.ItemNotFoundException;
import dev.kush.countrycity.model.Country;
import dev.kush.countrycity.repository.CountryRepository;
import dev.kush.countrycity.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;


    @Override
    public List<Country> findAllCountries() {
        return countryRepository.findAll();
    }

    @Override
    public Country findByCountryId(Long countryId) {
        return getCountryById(countryId);
    }

    private Country getCountryById(Long countryId) {
        return countryRepository.findById(countryId)
                .orElseThrow(() -> new ItemNotFoundException("Country not found."));
    }

    @Override
    public Country saveCountry(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public Country deleteCountry(Long countryId) {
        Country country = getCountryById(countryId);
        countryRepository.delete(country);
        return country;
    }
}
