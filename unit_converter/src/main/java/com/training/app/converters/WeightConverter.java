package com.training.app.converters;

import org.springframework.stereotype.Component;

import com.training.app.components.ConvertUnits;

@Component
public class WeightConverter implements ConvertUnits {

    @Override
    public Double convert(String from, String to, Double value) {
        Double result = switch (from.toLowerCase()) {
            case "tons" -> switch (to.toLowerCase()) {
                case "kilograms" -> value * 1000L;
                case "grams" -> value * 1000000L;
                case "milligrams" -> value * 1000000000L;
                case "micrograms" -> value * 1000000000000L;
                default -> throw new IllegalArgumentException("Invalid conversion");
            };
            case "kilograms" -> switch (to.toLowerCase()) {
                case "tons" -> value / 1000;
                case "grams" -> value * 1000L;
                case "milligrams" -> value * 1000000L;
                case "micrograms" -> value * 1000000000L;
                default -> throw new IllegalArgumentException("Invalid conversion");
            };
            case "grams" -> switch (to.toLowerCase()) {
                case "tons" -> value / 1000000L;
                case "kilograms" -> value / 1000L;
                case "milligrams" -> value * 1000;
                case "micrograms" -> value * 1000000;
                default -> throw new IllegalArgumentException("Invalid conversion");
            };
            case "milligrams" -> switch (to.toLowerCase()) {
                case "tons" -> value / 1000000000;
                case "kilograms" -> value / 1000000;
                case "grams" -> value / 1000;
                case "micrograms" -> value * 1000;
                default -> throw new IllegalArgumentException("Invalid conversion");
            };
            case "micrograms" -> switch (to.toLowerCase()) {
                case "tons" -> value / 1000000000000L;
                case "kilograms" -> value / 1000000000L;
                case "grams" -> value / 1000000L;
                case "milligrams" -> value / 1000L;
                default -> throw new IllegalArgumentException("Invalid conversion");
            };
            default -> throw new IllegalArgumentException("invalid unit");
        };
        return result;
    }
}
