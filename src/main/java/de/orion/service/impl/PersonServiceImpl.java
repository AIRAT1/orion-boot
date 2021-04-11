package de.orion.service.impl;

import de.orion.dto.PersonDto;
import de.orion.service.PersonService;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {
    @Override
    public PersonDto findById(String id) {
        return PersonDto.builder().id(id).build();
    }

    @Override
    public PersonDto create(PersonDto personDto) {
        return personDto;
    }

    @Override
    public PersonDto update(PersonDto personDto, String id) {
        return personDto;
    }

    @Override
    public void delete(String id) {

    }
}
