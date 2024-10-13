package com.training.app.services;

import org.springframework.stereotype.Service;

import com.training.app.components.ValidationAndRounding;
import com.training.app.converters.TemperatureConverter;

@Service
public class TemperatureConverterService extends ValidationAndRounding {

    private final TemperatureConverter temperatureConverter;

    public TemperatureConverterService(TemperatureConverter temperatureConverter) {
        this.temperatureConverter = temperatureConverter;
    }

    @Override
    public Double convert(String from, String to, Double value) {
        validate(from, to, value);
        return round(temperatureConverter.convert(from, to, value),8);
    }

}
