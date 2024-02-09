package dev.kush.countrycity.controller;

import dev.kush.countrycity.dto.StateDto;
import dev.kush.countrycity.model.State;
import dev.kush.countrycity.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/state")
public class StateController {

    @Autowired
    private StateService stateService;

    @GetMapping("/all")
    public List<State> getAllStates() {
        return stateService.getAllStates();
    }

    @GetMapping("/get/{id}")
    public State getStateById(@PathVariable Long id) {
        return stateService.getStateById(id);
    }

    @PostMapping("/add")
    public State addState(@RequestBody StateDto stateDto) {
        return stateService.saveState(stateDto);
    }

    @DeleteMapping("/delete/{id}")
    public State deleteState(@PathVariable Long id) {
        return stateService.deleteState(id);
    }
}
