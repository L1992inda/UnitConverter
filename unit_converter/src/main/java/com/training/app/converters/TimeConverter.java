package com.training.app.converters;

import org.springframework.stereotype.Component;

import com.training.app.components.ConvertUnits;

@Component
public class TimeConverter implements ConvertUnits {

    @Override
    public Double convert(String from, String to, Double value) {

        Double result = switch (from.toLowerCase()) {
            case "seconds" -> switch (to.toLowerCase()) {
                case "minutes" -> value / 60;
                case "hours" -> value / 3600;
                case "days" ->   value / 86400;
                default -> throw new IllegalArgumentException("Invalid conversion");
            };
            case "minutes" -> switch (to.toLowerCase()) {
                case "seconds" -> value * 60;
                case "hours" -> value / 60;
                case "days" -> value /1440;
                default -> throw new IllegalArgumentException("Invalid conversion");
            };
            case "hours" -> switch (to.toLowerCase()) {
                case "seconds" -> value * 3600;
                case "minutes" -> value * 60;
                case "days" -> value / 24;
                default -> throw new IllegalArgumentException("Invalid conversion");
            };
            case "days" -> switch (to.toLowerCase()) {
                case "seconds" -> value * 86400;
                case "minutes" -> value * 1440;
                case "hours" -> value * 24;
                default -> throw new IllegalArgumentException("Invalid conversion");
            };             
            default -> throw new IllegalArgumentException("invalid unit");
        };
        return result;
    }  
}

