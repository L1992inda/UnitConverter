package com.training.app.services;

import org.springframework.stereotype.Service;

import com.training.app.components.ValidationAndRounding;
import com.training.app.converters.LengthConverter;

@Service
public class LengthConverterService extends ValidationAndRounding {

    private final LengthConverter lengthConverter;

    public LengthConverterService(LengthConverter lengthConverter) {
        this.lengthConverter = lengthConverter;
    }

    public Double convert(String from, String to, Double value) {
        validate(from, to, value);
        return round(lengthConverter.convert(from, to, value),8);
    }
}
