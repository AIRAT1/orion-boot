package de.orion.service.impl;

import de.orion.dto.PersonDto;
import de.orion.service.PersonService;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {
    @Override
    public PersonDto findPersonById(String id) {
        return PersonDto.builder().id(id).build();
    }
}
