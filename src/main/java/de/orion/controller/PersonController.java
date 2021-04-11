package de.orion.controller;

import de.orion.dto.PersonDto;
import de.orion.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class PersonController {
    private final PersonService personService;

    @GetMapping(value = "/{id}")
    public PersonDto findById (@PathVariable("id") String id) {
        return personService.findById(id);
    }

    @PostMapping
    public PersonDto create(@RequestBody PersonDto personDto) {
        return personService.create(personDto);
    }

    @PutMapping("/{id}")
    public PersonDto update(@RequestBody PersonDto personDto, @PathVariable("id") String id) {
        return personService.update(personDto, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        personService.delete(id);
    }
}
