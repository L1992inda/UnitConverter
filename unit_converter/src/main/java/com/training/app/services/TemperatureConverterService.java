package com.training.app.services;

import org.springframework.stereotype.Service;

import com.training.app.components.ConvertUnits;
import com.training.app.components.ValueCheck;
import com.training.app.converters.TemperatureConverter;

@Service
public class TemperatureConverterService extends ValueCheck implements ConvertUnits {

    private final TemperatureConverter temperatureConverter;

    public TemperatureConverterService(TemperatureConverter temperatureConverter) {
        this.temperatureConverter = temperatureConverter;
    }

    @Override
    public Double convert(String from, String to, Double value) {
        validate(from, to, value);
        return temperatureConverter.convert(from, to, value);
    }

}
