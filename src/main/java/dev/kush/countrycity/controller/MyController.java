package dev.kush.countrycity.controller;

import dev.kush.countrycity.model.City;
import dev.kush.countrycity.model.Country;
import dev.kush.countrycity.model.State;
import dev.kush.countrycity.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class MyController {

    @Autowired
    private MyService myService;

    @GetMapping("/countries")
    public List<Country> getCountryList() {
        return myService.getCountryList();
    }

    @GetMapping("/states/{countryName}")
    public List<State> getStateList(@PathVariable String countryName) {
        return myService.getStateList(countryName);
    }

    @GetMapping("/cities/{stateName}")
    public List<City> getCityList(@PathVariable String stateName) {
        return myService.getCityList(stateName);
    }
}
