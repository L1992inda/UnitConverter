package com.training.app.services;

import org.springframework.stereotype.Service;
import com.training.app.converters.TemperatureConverter;

@Service
public class TemperatureConverterService {

    private final TemperatureConverter temperatureConverter;

   
    public TemperatureConverterService(TemperatureConverter temperatureConverter) {
        this.temperatureConverter = temperatureConverter;
    }

    public double convert(String from, String to, Double value) {
        if(from.isBlank() || to.isBlank() || value == null){
            throw new IllegalArgumentException("Input can't be empty");
        }
        return temperatureConverter.convert(from,to,value);
    }
}
