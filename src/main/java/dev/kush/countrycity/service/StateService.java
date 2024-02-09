package dev.kush.countrycity.service;

import dev.kush.countrycity.dto.StateDto;
import dev.kush.countrycity.model.State;

import java.util.List;

public interface StateService {
    List<State> getAllStates();

    State getStateById(Long stateId);
    State saveState(StateDto stateDto);
    State deleteState(Long stateId);
}
