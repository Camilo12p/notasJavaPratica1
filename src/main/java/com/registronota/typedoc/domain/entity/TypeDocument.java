package com.registronota.typedoc.domain.entity;

public class TypeDocument {

    private int id;
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

    

}
