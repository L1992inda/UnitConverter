package com.training.app.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.app.services.TemperatureConverterService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UnitConverterController {

    private final TemperatureConverterService unitConverterService;

    public UnitConverterController(TemperatureConverterService unitConverterService) {
        this.unitConverterService = unitConverterService;
    }

    @GetMapping("/temperature")
    public double temperatureConverter(@RequestParam String from,@RequestParam String to,@RequestParam Double value) {
        return unitConverterService.convert(from, to, value);
    }

}
