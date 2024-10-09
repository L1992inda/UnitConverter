package com.training.app.components;

public abstract class ValueCheck {

    public void validate (String from, String to, Double value) {
        if(from.isBlank() || to.isBlank() || value == null){
            throw new IllegalArgumentException("Input can't be empty");
        }      
    }   
}
