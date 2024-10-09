package com.training.app.services;

import org.springframework.stereotype.Service;

import com.training.app.components.ConvertUnits;
import com.training.app.components.ValueCheck;
import com.training.app.converters.WeightConverter;

@Service
public class WeightConverterService extends ValueCheck implements ConvertUnits {
    private final WeightConverter weightConverter;

    public WeightConverterService(WeightConverter weightConverter) {
        this.weightConverter = weightConverter;
    }

    @Override
    public Double convert(String from, String to, Double value) {
        validate(from, to, value);
        return weightConverter.convert(from, to, value);
    }

}
