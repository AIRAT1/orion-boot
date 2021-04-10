package de.orion.controller;

import de.orion.dto.PersonDto;
import de.orion.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class PersonController {
    private final PersonService personService;

    @GetMapping(value = "/{id}")
    public PersonDto findPersonById (@PathVariable("id") String id) {
        return personService.findPersonById(id);
    }
}
