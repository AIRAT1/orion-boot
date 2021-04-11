package de.orion.service;

import de.orion.dto.PersonDto;

public interface PersonService {
    PersonDto findById(String id);
    PersonDto create(PersonDto personDto);
    PersonDto update(PersonDto personDto, String id);
    void delete(String id);
}
