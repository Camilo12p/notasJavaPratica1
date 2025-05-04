package com.registronota.rolPerson.application;


import java.util.Optional;

import com.registronota.rolPerson.domain.entity.RolPerson;
import com.registronota.rolPerson.domain.service.RolPersonServiceRepo;

public class GetRolPersonByIdUseCase {

    private RolPersonServiceRepo rolPersonRepository;

    public GetRolPersonByIdUseCase(RolPersonServiceRepo rolPersonRepository) {
        this.rolPersonRepository = rolPersonRepository;
    }

    public Optional<RolPerson> execute ( int id){
        return rolPersonRepository.getRolPersonById(id);
    }

}
