package com.training.app.converters;

import org.springframework.stereotype.Component;

import com.training.app.values.Values;

@Component
public class TemperatureConverter implements Values {

    @Override
    public double convert(String from, String to, Double value) {

        if (from.equalsIgnoreCase("celsius") && to.equalsIgnoreCase("fahrenheit")) {
            return (value * 1.8) + 32;
        } else if (from.equalsIgnoreCase("fahrenheit") && to.equalsIgnoreCase("celsius")) {
            return (value - 32) / 1.8;
        } else {
            throw new IllegalArgumentException("Pleas add valid temperature");
        }
    }
}
