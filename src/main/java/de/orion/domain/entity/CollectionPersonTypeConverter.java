package de.orion.domain.entity;

import de.orion.domain.enums.PersonType;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Converter
public class CollectionPersonTypeConverter implements AttributeConverter<PersonTypeContainer, String> {
    @Override
    public String convertToDatabaseColumn(PersonTypeContainer attribute) {
        return attribute.getPersonTypes().stream()
                .map(PersonType::name)
                .collect(Collectors.joining(","));
    }

    @Override
    public PersonTypeContainer convertToEntityAttribute(String dbData) {
        return PersonTypeContainer.builder()
                .personTypes(
                        Stream.of(dbData.split(","))
                                .filter(StringUtils::isNoneEmpty)
                                .map(PersonType::valueOf)
                                .collect(Collectors.toList())
                )
                .build();
    }
}
