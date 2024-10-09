package com.training.app.services;

import org.springframework.stereotype.Service;

import com.training.app.components.ConvertUnits;
import com.training.app.components.ValueCheck;
import com.training.app.converters.TimeConverter;

@Service
public class TimeConverterService extends ValueCheck  implements ConvertUnits {

    private final TimeConverter timeConverter;

    public TimeConverterService(TimeConverter timeConverter) {
        this.timeConverter = timeConverter;
    }

    @Override
    public Double convert(String from, String to, Double value) {
        validate(from, to, value);
        return timeConverter.convert(from, to, value);
    }
}
