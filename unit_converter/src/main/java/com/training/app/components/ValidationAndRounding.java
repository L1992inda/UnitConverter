package com.training.app.components;
import java.math.BigDecimal;
import java.math.RoundingMode;


public abstract class ValidationAndRounding implements ConvertUnits {

    public void validate (String from, String to, Double value) {
        if(from.isBlank() || to.isBlank() || value == null){
            throw new IllegalArgumentException("Input can't be empty");
        }      
    } 
    
    public Double round(Double value, int places) {
        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
      }
}
