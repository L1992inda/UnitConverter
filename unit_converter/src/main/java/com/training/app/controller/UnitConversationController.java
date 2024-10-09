package com.training.app.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.app.services.LengthConverterService;
import com.training.app.services.TemperatureConverterService;
import com.training.app.services.TimeConverterService;
import com.training.app.services.WeightConverterService;

@RestController
@RequestMapping("/convert")
@CrossOrigin(origins = "http://localhost:3000")
public class UnitConversationController {

    private final TemperatureConverterService temperatureConverter;
    private final LengthConverterService lengthConverter;
    private final TimeConverterService timeConverter;
    private final WeightConverterService weightConverter;

    public UnitConversationController(
        TemperatureConverterService temperatureConverter,
        LengthConverterService lengthConverter, 
        TimeConverterService timeConverter,
        WeightConverterService weightConverter) {
            this.temperatureConverter = temperatureConverter;
            this.lengthConverter = lengthConverter;
            this.timeConverter = timeConverter;
            this.weightConverter = weightConverter;
    }

    @GetMapping("/temperature")
    public double temperatureConverter(@RequestParam String from, @RequestParam String to, @RequestParam Double value) {
        return temperatureConverter.convert(from, to, value);
    }

    @GetMapping("/length")
    public double lengthConverter(@RequestParam String from, @RequestParam String to, @RequestParam Double value) {
        return lengthConverter.convert(from, to, value);
    }

    @GetMapping("/time")
    public double timeConverter(@RequestParam String from, @RequestParam String to, @RequestParam Double value) {
        return timeConverter.convert(from, to, value);
    }

    @GetMapping("/weight")
    public double weightConverter(@RequestParam String from, @RequestParam String to, @RequestParam Double value) {
        return weightConverter.convert(from, to, value);
    }

}
