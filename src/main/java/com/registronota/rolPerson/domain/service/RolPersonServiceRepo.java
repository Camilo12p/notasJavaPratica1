package com.registronota.rolPerson.domain.service;

import java.util.Optional;

import com.registronota.rolPerson.domain.entity.RolPerson;

public interface RolPersonServiceRepo {

    public Optional<RolPerson> getRolPersonById(int id);

}
