package de.orion.converter;


import de.orion.domain.dto.PersonDto;
import de.orion.domain.entity.Person;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PersonPersonDtoConverter implements Converter<Person, PersonDto> {
    @Override
    public PersonDto convert(Person person) {
        return PersonDto.builder()
                .id(person.getId())
                .addressId(person.getAddressId())
                .age(person.getAge())
                .email(person.getEmail())
                .name(person.getName())
                .build();
    }
}
