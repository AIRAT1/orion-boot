package de.orion.converter;

import de.orion.domain.dto.PersonDto;
import de.orion.domain.entity.Person;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PersonDtoPersonConverter implements Converter<PersonDto, Person> {
    @Override
    public Person convert(PersonDto personDto) {
        Person person = new Person();
        person.setAddressId(personDto.getAddressId());
        person.setAge(personDto.getAge());
        person.setEmail(personDto.getEmail());
        person.setName(personDto.getName());
        return person;
    }
}
