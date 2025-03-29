package com.registronota.persona.infrastructure.in;

import com.registronota.persona.application.CreatePersonUseCase;
import com.registronota.persona.application.DeletePersonUseCase;
import com.registronota.persona.domain.Person;

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
        Person person = new Person();

        
    }

}
