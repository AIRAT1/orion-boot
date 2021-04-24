package de.orion.service.impl;

import de.orion.controller.exception.PersonNotFoundException;
import de.orion.domain.dto.PersonDto;
import de.orion.domain.entity.Person;
import de.orion.repository.CustomPersonRepository;
import de.orion.repository.PersonRepository;
import de.orion.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;
    private final CustomPersonRepository customPersonRepository;
    private final ConversionService conversionService;

    @Override
    public PersonDto findById(UUID id) {
//        Person person = personRepository.getOne(id);
        Person person = customPersonRepository.get(id);
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
//        Person result = personRepository.save(person);
        Person result = customPersonRepository.update(person);
        return conversionService.convert(result, PersonDto.class);
    }

    @Override
    public PersonDto updateByPatch(PersonDto personDto, UUID id) {
        return personDto;
    }

    @Override
    public void delete(UUID id) {
//        personRepository.delete(personRepository.findById(id).get());
        customPersonRepository.deleteById(id);
    }

    @Override
    public Page <PersonDto> getAll(Pageable pageable) {
        return personRepository.findAll(pageable)
                .map(person -> conversionService.convert(person, PersonDto.class));
    }

    public void specExample() {
        personRepository.findAll((root, query, criteriaBuilder) -> criteriaBuilder.and(criteriaBuilder.like(root.get("email"), "email")));
    }
}
