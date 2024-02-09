package dev.kush.countrycity.controller;

import dev.kush.countrycity.model.Country;
import dev.kush.countrycity.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/all")
    public List<Country> getAll() {
        return countryService.findAllCountries();
    }

    @GetMapping("/get/{id}")
    public Country getCountryById(@PathVariable("id") Long id) {
        return countryService.findByCountryId(id);
    }

    @PostMapping("/add")
    public Country addCountry(@RequestBody Country country) {
        return countryService.saveCountry(country);
    }

    @DeleteMapping("/delete/{id}")
    public Country deleteCountry(@PathVariable("id") Long id) {
        return countryService.deleteCountry(id);
    }
}
