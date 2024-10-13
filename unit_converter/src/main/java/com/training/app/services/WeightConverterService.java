package com.training.app.services;

import org.springframework.stereotype.Service;

import com.training.app.components.ValidationAndRounding;
import com.training.app.converters.WeightConverter;

@Service
public class WeightConverterService extends ValidationAndRounding {
    private final WeightConverter weightConverter;

    public WeightConverterService(WeightConverter weightConverter) {
        this.weightConverter = weightConverter;
    }

    @Override
    public Double convert(String from, String to, Double value) {
        validate(from, to, value);
        Double result = weightConverter.convert(from, to, value);
        if (result < 1) {
            return result;
        } else {
            return round(result, 8);
        }
    }
}
