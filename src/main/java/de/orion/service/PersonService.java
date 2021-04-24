package de.orion.service;

import de.orion.domain.dto.PersonDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Validated
public interface PersonService {
    PersonDto findById(@NotNull UUID id);

    PersonDto create(PersonDto personDto);

    PersonDto updateByPut(PersonDto personDto, UUID id);

    PersonDto updateByPatch(PersonDto personDto, UUID id);

    void delete(UUID id);

    Page<PersonDto> getAll(Pageable pageable);
}
