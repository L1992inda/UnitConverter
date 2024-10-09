package com.training.app.services;

import org.springframework.stereotype.Service;

import com.training.app.components.ConvertUnits;
import com.training.app.components.ValueCheck;
import com.training.app.converters.LengthConverter;

@Service
public class LengthConverterService extends ValueCheck implements ConvertUnits {

    private final LengthConverter lengthConverter;

    public LengthConverterService(LengthConverter lengthConverter) {
        this.lengthConverter = lengthConverter;
    }

    @Override
    public Double convert(String from, String to, Double value) {
        validate(from, to, value);
        return lengthConverter.convert(from, to, value);
    }
}
