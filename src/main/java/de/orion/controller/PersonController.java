package de.orion.controller;

import de.orion.dto.PersonDto;
import de.orion.service.PersonService;
import de.orion.validator.mvc.PersonDtoValidator;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class PersonController {
    private final PersonService personService;
    private final PersonDtoValidator personDtoValidator;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(personDtoValidator);
    }

    @GetMapping(value = "/{id}")
    public PersonDto findById (@PathVariable("id") String id) {
        return personService.findById(id);
    }

    @PostMapping
    public PersonDto create(@Valid @RequestBody PersonDto personDto) {
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

    @SneakyThrows
    @PostMapping("/file")
    public String handleFile(@RequestParam("file")MultipartFile file) {
        return IOUtils.toString(file.getBytes(), StandardCharsets.UTF_8.name());
    }

    @GetMapping("/redirect")
    public RedirectView redirect() {
        return new RedirectView("/persons/2");
    }

    @SneakyThrows
    @GetMapping("/redirect-from-response")
    public void redirectFromResponse(HttpServletResponse servletResponse) {
        servletResponse.sendRedirect("/persons/3");
    }

    @GetMapping("/redirect-from-model")
    public ModelAndView redirectFromModel() {
        return new ModelAndView("redirect:/persons/4");
    }

    @GetMapping("/forward")
    public ModelAndView forward() {
        return new ModelAndView("forward:/persons/5");
    }
}
