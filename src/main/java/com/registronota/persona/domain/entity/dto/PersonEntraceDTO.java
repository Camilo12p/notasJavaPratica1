package com.registronota.persona.domain.entity.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonAlias;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


public class PersonEntraceDTO {

    @JsonAlias("id_person")
    @Min(value = 1 , message = "id no valid")
    @NotNull(message = "id can't null")
    private long id;


    @JsonAlias("id_type_document_person")
    @Min(value = 1, message = "id of type document is not valid")
    @NotNull(message = "id type can't null")
    private int idTypeDocument;

    @JsonAlias("name_person")
    @NotBlank(message = "name is mandatory")
    @Size(max = 30, message = "the name's size is very long")
    private String name;

    @JsonAlias("last_name_person")
    @NotBlank(message = "lastname is mandatory")
    @Size(max = 30, message = "the lastname's size is very long")
    private String lastName;

    @JsonAlias("birth_date_person")
    @Past(message = "the Date has to be past")
    private LocalDate birthDate;

    @JsonAlias("email_person")
    @Email(message = "email is not valid")
    @NotBlank(message = "email is mandatory")
    private String email;
    
    @JsonAlias("password_person")
    @NotBlank(message = "password is mandatory")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).+$", message = "password has to have a supperCase , a lowCase and a number")
    @Size(min = 5, max = 30, message = "password is not valid")
    private String password;

    @JsonAlias("phone_number_person")
    @NotNull
    @Min(value = 99999, message = "phone number is not valid")
    private long phoneNumber; 
     

    // constructors

    public PersonEntraceDTO (){

    }

    // getters and setters 

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public int getIdTypeDocument() {
        return idTypeDocument;
    }
    public void setIdTypeDocument(int idTypeDocument) {
        this.idTypeDocument = idTypeDocument;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public LocalDate getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
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


    // to string
    @Override
    public String toString() {
        return "PersonEntradaDTO [id=" + id + ", idTypeDocument=" + idTypeDocument + ", name=" + name + ", lastName="
                + lastName + ", birthDate=" + birthDate + ", email=" + email + ", password=" + password
                + ", phoneNumber=" + phoneNumber + "]";
    }


    

}
