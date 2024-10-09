package com.training.app.services;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.training.app.unit.Unit;

@Service
public class UnitsService {

    public Map<String, List<Unit>> units() {

        Map<String, List<Unit>> unitsMap = new HashMap<>();

        List<Unit> temperatureList = Arrays.asList(
                new Unit("Celsius", "℃"),
                new Unit("Fahrenheit", "℉"),
                new Unit("Kelvin", "K"));

        List<Unit> lengthList = Arrays.asList(
                new Unit("Millimeters", "mm"),
                new Unit("Centimeters", "cm"),
                new Unit("Decimeters", "dm"),
                new Unit("Meters", "m"),
                new Unit("Kilometers", "Km"));

        List<Unit> weightList = Arrays.asList(
                new Unit("Micrograms", "μg"),
                new Unit("Milligrams", "mg"),
                new Unit("Grams", "g"),
                new Unit("Kilograms", "kg"),
                new Unit("Tons", "t"));

        List<Unit> timeList = Arrays.asList(
                new Unit("Seconds", "s"),
                new Unit("Minutes", "min"),
                new Unit("Hours", "h"),
                new Unit("Days", "d"));

        unitsMap.put("Temperature", temperatureList);
        unitsMap.put("Length", lengthList);
        unitsMap.put("Weight", weightList);
        unitsMap.put("Time", timeList);

        return unitsMap;
    }
}
