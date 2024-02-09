package dev.kush.countrycity.service.impl;

import dev.kush.countrycity.dto.StateDto;
import dev.kush.countrycity.exception.ItemNotFoundException;
import dev.kush.countrycity.model.State;
import dev.kush.countrycity.repository.StateRepository;
import dev.kush.countrycity.service.CountryService;
import dev.kush.countrycity.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateServiceImpl implements StateService {

    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private CountryService countryService;


    @Override
    public List<State> getAllStates() {
        return stateRepository.findAll();
    }

    @Override
    public State getStateById(Long stateId) {
        return getStateByIdMethod(stateId);
    }

    private State getStateByIdMethod(Long stateId) {
        return stateRepository.findById(stateId).orElseThrow(
                () -> new ItemNotFoundException("State not found."));
    }

    @Override
    public State saveState(StateDto stateDto) {
        return stateRepository.save(
                new State(
                        stateDto.stateName(),
                        stateDto.capital(),
                        countryService.findByCountryId(stateDto.countryId())
                ));

    }

    @Override
    public State deleteState(Long stateId) {
        State state = getStateByIdMethod(stateId);
        stateRepository.delete(state);
        return state;
    }
}
