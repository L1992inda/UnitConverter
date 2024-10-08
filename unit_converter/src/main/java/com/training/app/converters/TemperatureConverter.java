package com.training.app.converters;

import org.springframework.stereotype.Component;

import com.training.app.values.Values;

@Component
public class TemperatureConverter implements Values {

    @Override
    public double convert(String from, String to, Double value) {

        return switch (from.toLowerCase()) {
            case "celsius" -> {
                yield switch (to.toLowerCase()) {
                    case "fahrenheit" -> (value * 1.8) + 32;
                    case "kelvin" -> value + 273.15;
                    default -> throw new IllegalArgumentException("unit cant dublicate");
                };
            }
            case "fahrenheit" -> {
                yield switch (to.toLowerCase()) {
                    case "celsius" -> (value - 32) / 1.8;
                    case "kelvin" -> ((value - 32) / 1.8) + 273.15;
                    default -> throw new IllegalArgumentException("unit cant dublicate");
                };
            }
            case "kelvin" -> {
                yield switch (to.toLowerCase()) {
                    case "celsius" -> value - 273.15; 
                    case "fahrenheit" -> ((value - 273.15) * 1.8) + 32;
                    default -> throw new IllegalArgumentException("unit cant dublicate");
                };
            }

            default -> throw new IllegalArgumentException("invalid unit");
        };

    }
}
