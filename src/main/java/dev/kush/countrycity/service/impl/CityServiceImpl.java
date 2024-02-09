package dev.kush.countrycity.service.impl;

import dev.kush.countrycity.dto.CityDto;
import dev.kush.countrycity.model.City;
import dev.kush.countrycity.repository.CityRepository;
import dev.kush.countrycity.service.CityService;
import dev.kush.countrycity.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private StateService stateService;

    @Override
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    @Override
    public City getCityById(Long cityId) {
        return findCityByIDMethod(cityId);
    }

    private City findCityByIDMethod(Long cityId) {
        return cityRepository.findById(cityId).orElseThrow(
                () -> new IllegalArgumentException("City not found with id: " + cityId)
        );
    }

    @Override
    public City saveCity(CityDto cityDto) {
        return cityRepository.save(
                new City(
                        cityDto.cityName(),
                        stateService.getStateById(cityDto.stateId())
                )
        );
    }

    @Override
    public City deleteCity(Long cityId) {
        City city = findCityByIDMethod(cityId);
        cityRepository.delete(city);
        return city;
    }
}
