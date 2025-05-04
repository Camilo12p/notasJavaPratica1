package com.registronota.rolPerson.domain.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class RolPerson {

    @JsonProperty("id_rol_person")
    @NotNull(message = "id can't null")
    @Min(value = 1, message = "el id no se valido")
    private int id;

    @JsonProperty("name_rol_person")
    @NotBlank(message = "name no valid")
    private String name;


    // constructors
    public RolPerson() {
    }


    // getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    // to String

    @Override
    public String toString() {
        return "RolPerson [id=" + id + ", name=" + name + "]";
    }



    
    

}
