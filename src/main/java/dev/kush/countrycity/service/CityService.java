package dev.kush.countrycity.service;

import dev.kush.countrycity.dto.CityDto;
import dev.kush.countrycity.model.City;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CityService {
    List<City> getAllCities();
    City getCityById(Long cityId);
    City saveCity(CityDto cityDto);
    City deleteCity(Long cityId);
}
