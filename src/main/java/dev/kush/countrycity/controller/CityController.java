package dev.kush.countrycity.controller;

import dev.kush.countrycity.dto.CityDto;
import dev.kush.countrycity.model.City;
import dev.kush.countrycity.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping("/all")
    public List<City> getAll() {
        return cityService.getAllCities();
    }

    @GetMapping("/get/{id}")
    public City getCity(@PathVariable Long id) {
        return cityService.getCityById(id);
    }

    @PostMapping("/add")
    public City addCity(@RequestBody CityDto cityDto) {
        return cityService.saveCity(cityDto);
    }

    @DeleteMapping("/delete/{id}")
    public City deleteCity(@PathVariable Long id) {
        return cityService.deleteCity(id);
    }
}
