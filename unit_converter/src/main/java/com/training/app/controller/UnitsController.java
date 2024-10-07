package com.training.app.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.app.services.UnitsService;
import com.training.app.unit.Unit;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UnitsController {

    private final UnitsService service;

public UnitsController(UnitsService service) {
        this.service = service;
    }

@GetMapping("/units")
    public Map<String, List<Unit>> getUnits() {
       return service.units();

    }

    
}
