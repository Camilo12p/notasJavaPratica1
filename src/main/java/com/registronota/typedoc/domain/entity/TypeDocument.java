package com.registronota.typedoc.domain.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TypeDocument {

    @JsonProperty("id_type_document")
    private int id;

    @JsonProperty("name_type_document")
    private String name;
    
    
    // constructors 
    
    public TypeDocument(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public TypeDocument(){
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


    // toString


    @Override
    public String toString() {
        return "TypeDocument [id=" + id + ", name=" + name + "]";
    }
    

}
