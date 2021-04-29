package de.orion.domain.entity;

import de.orion.domain.enums.PersonType;
import lombok.Builder;
import lombok.Getter;

import java.util.Collection;

@Getter
@Builder
public class PersonTypeContainer {
    private Collection<PersonType> personTypes;
}
