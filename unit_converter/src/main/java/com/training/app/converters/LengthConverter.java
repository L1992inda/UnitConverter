package com.training.app.converters;

import org.springframework.stereotype.Component;

import com.training.app.components.ConvertUnits;

@Component
public class LengthConverter implements ConvertUnits{

    @Override
    public Double convert(String from, String to, Double value) {

        return switch (from.toLowerCase()) {
            case "millimeters" -> switch (to.toLowerCase()) {
                case "centimeters" -> value / 10;
                case "decimeters" -> value / 100;
                case "meters" -> value / 1000;
                case "kilometers" -> value / 1000000;
                default -> throw new IllegalArgumentException("Invalid conversion");
            };
            case "centimeters" -> switch (to.toLowerCase()) {
                case "millimeters" -> value * 10;
                case "decimeters" -> value / 10;
                case "meters" -> value / 100;
                case "kilometers" -> value / 100000;
                default -> throw new IllegalArgumentException("Invalid conversion");
            };
            case "decimeters" -> switch (to.toLowerCase()) {
                case "millimeters" -> value * 100;
                case "centimeters" -> value * 10;
                case "meters" -> value / 10;
                case "kilometers" -> value / 10000L;
                default -> throw new IllegalArgumentException("Invalid conversion");
            };
            case "meters" -> switch (to.toLowerCase()) {
                case "millimeters" -> value / 1000000000;
                case "centimeters" -> value / 1000000;
                case "decimeters" -> value / 1000;
                case "kilometers" -> value * 1000L;
                default -> throw new IllegalArgumentException("Invalid conversion");
            };
            case "kilometers" -> switch (to.toLowerCase()) {
                case "millimeters" -> value * 1000000L;
                case "centimeters" -> value * 100000L;
                case "decimeters" -> value * 10000L;
                case "meters" -> value * 100;
                default -> throw new IllegalArgumentException("Invalid conversion");
            };
            default -> throw new IllegalArgumentException("invalid unit");
        };
    }  
}
