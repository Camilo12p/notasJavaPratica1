package com.registronota.serverconfig;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorsData {

    

    @JsonProperty("errors")
    private List<String> errors;

    
    
    
    
    public ErrorsData(List<String> errors) {
        this.errors = errors;
    }


    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    

    
}

