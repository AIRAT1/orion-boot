package de.orion.service.impl;

import de.orion.controller.exception.PersonNotFoundException;
import de.orion.dto.PersonDto;
import de.orion.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PersonServiceImpl implements PersonService {

    private static final Map<String, PersonDto> personById;

    static {
        Map<String, PersonDto> personDtoMap = new HashMap<>();
        personDtoMap.put("1", PersonDto.builder().id("1").build());
        personById = personDtoMap;
    }

    @Override
    public PersonDto findById(String id) {
        if (personById.containsKey(id)) {
            return personById.get(id);
        }
        throw new PersonNotFoundException();
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
