package com.registronota;

import java.time.LocalDate;

import com.registronota.persona.application.CreatePersonUseCase;
import com.registronota.persona.application.DeletePersonUseCase;
import com.registronota.persona.domain.entity.Person;
import com.registronota.persona.domain.service.PersonService;
import com.registronota.persona.infrastructure.in.repositorymysql.PersonRepository;
import com.registronota.serverconfig.ConfigServer;

public class Main {
    public static void main(String[] args) {

        ConfigServer.startServer();
        
        // Person person = new Person(1,1,"camilo","patiño",LocalDate.of(2023, 3, 1),321402);

        // PersonService personRepository = new PersonRepository();
        // CreatePersonUseCase createpersonUC = new CreatePersonUseCase(personRepository);

        // createpersonUC.execute(person);

        // DeletePersonUseCase deletePersonUC = new DeletePersonUseCase(personRepository);
        // deletePersonUC.execute(1);
    }
}