package de.orion.service;

import de.orion.dto.PersonDto;

public interface PersonService {
    PersonDto findPersonById(String id);
}
