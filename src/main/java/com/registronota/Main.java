package com.registronota;

import java.time.LocalDate;

import com.registronota.persona.application.CreatePersonUseCase;
import com.registronota.persona.domain.PersonService;
import com.registronota.persona.domain.entity.Person;
import com.registronota.persona.infrastructure.out.PersonRepository;

public class Main {
    public static void main(String[] args) {
        
        // Person person = new Person(1,1,"camilo","patiño",LocalDate.of(2023, 3, 1),321402);

        // PersonService personRepository = new PersonRepository();
        // CreatePersonUseCase createpersonUC = new CreatePersonUseCase(personRepository);

        // createpersonUC.execute(person);
    }
}