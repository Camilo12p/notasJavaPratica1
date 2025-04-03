package com.registronota.persona.infrastructure.in;

import java.util.Scanner;

import com.registronota.persona.application.CreatePersonUseCase;
import com.registronota.persona.application.DeletePersonUseCase;
import com.registronota.persona.domain.entity.Person;

public class PersonaUI {

    private CreatePersonUseCase createPerson;
    private DeletePersonUseCase deletePerson;

    public PersonaUI
    (  CreatePersonUseCase createPerson,
       DeletePersonUseCase deletePerson
    ){
        this.createPerson= createPerson;
        this.deletePerson = deletePerson;
            
    }

    public void Crear(){
        Scanner keyboardScanner = new Scanner(System.in);


        final String TITULO = """
                ++++++++++++++++++++++++++++++++++++++++++++
                + Bienvenidos al sistema de añadir Persona +
                ++++++++++++++++++++++++++++++++++++++++++++""";

        Person person = new Person();
        
        System.out.println(TITULO);

        System.out.println("Ingrese el id de la persona");
        person.setId(keyboardScanner.nextInt());
        keyboardScanner.next();
        person.setName(keyboardScanner.nextLine());
        keyboardScanner.next();
        person.setLastName(keyboardScanner.nextLine());
        keyboardScanner.next();
        


        
    }

}
