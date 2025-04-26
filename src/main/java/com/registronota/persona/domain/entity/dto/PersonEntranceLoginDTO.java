package com.registronota.persona.domain.entity.dto;

public class PersonEntranceLoginDTO {

    private String email;
    private String password;

    // constructors
    public PersonEntranceLoginDTO(){

    }

    
    // getters and setters
    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    //to String

    @Override
    public String toString() {
        return "PersonEntranceLoginDTO [email=" + email + ", password=" + password + "]";
    }

    
    

}
