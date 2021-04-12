package de.orion.service.impl;

import de.orion.controller.exception.PersonNotFoundException;
import de.orion.domain.dto.PersonDto;
import de.orion.domain.entity.Person;
import de.orion.repository.PersonRepository;
import de.orion.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;
    private final ConversionService conversionService;

    @Override
    public PersonDto findById(UUID id) {
        Person person = personRepository.getOne(id);
        return conversionService.convert(person, PersonDto.class);
    }

    @Override
    public PersonDto create(PersonDto personDto) {
        Person person = conversionService.convert(personDto, Person.class);
        Person result = personRepository.save(person);
        return conversionService.convert(result, PersonDto.class);
    }

    @Override
    public PersonDto updateByPut(PersonDto personDto, UUID id) {
        Person person = conversionService.convert(personDto, Person.class);
        person.setId(id);
        Person result = personRepository.save(person);
        return conversionService.convert(result, PersonDto.class);
    }

    @Override
    public PersonDto updateByPatch(PersonDto personDto, UUID id) {
        return personDto;
    }

    @Override
    public void delete(UUID id) {
        personRepository.delete(personRepository.findById(id).get());
    }

    @Override
    public List<PersonDto> getAll() {
        return personRepository.findAll().stream()
                .map(person -> conversionService.convert(person, PersonDto.class))
                .collect(Collectors.toList());
    }
}
