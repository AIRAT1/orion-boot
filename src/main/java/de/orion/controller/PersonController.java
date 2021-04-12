package de.orion.controller;

import de.orion.domain.dto.PersonDto;
import de.orion.service.PersonService;
import de.orion.validator.mvc.PersonDtoValidator;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Validated
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

    @GetMapping
    public List<PersonDto> getAll() {
        return personService.getAll();
    }

    @GetMapping(value = "/{id}")
    public PersonDto findById(@PathVariable("id") UUID id) {
        return personService.findById(null);
    }

    @PostMapping
    public PersonDto create(@Valid @RequestBody PersonDto personDto) {
        return personService.create(personDto);
    }

    @PutMapping("/{id}")
    public PersonDto updatePut(
            @RequestBody PersonDto personDto,
            @PathVariable("id") UUID id,
            @RequestParam("id") String paramId,
            @RequestHeader Map<String, String> headers,
            @RequestHeader(value = "Content-Type") String contentType,
            HttpServletRequest request,
            HttpServletResponse response
    ) {
        return personService.updateByPut(personDto, id);
    }

    @PatchMapping("/{id}")
    public PersonDto updatePatch(@RequestBody PersonDto personDto, @PathVariable("id") UUID id) {
        return personService.updateByPatch(personDto, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") UUID id) {
        personService.delete(id);
    }

    @SneakyThrows
    @PostMapping(value = "/file")
    public String handleFile(@RequestParam("file") MultipartFile file) {
        return IOUtils.toString(file.getBytes(), StandardCharsets.UTF_8.name());
    }

    @GetMapping("/redirect-by-model")
    public ModelAndView redirectByModel() {
        return new ModelAndView("redirect:/persons/2");
    }

    @SneakyThrows
    @GetMapping("/redirect-by-response")
    public void redirectFromResponse(HttpServletResponse servletResponse) {
        servletResponse.sendRedirect("/demo3/persons/3");
    }

    @GetMapping("/forward")
    public ModelAndView forward() {
        return new ModelAndView("forward:/persons/4");
    }
}
