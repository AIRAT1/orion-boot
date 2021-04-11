package de.orion.validator.mvc;

import de.orion.dto.AddressDto;
import de.orion.dto.PersonDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class PersonDtoValidator implements Validator {
    private final AddressDtoValidator addressDtoValidator;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(PersonDto.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        PersonDto personDto = (PersonDto) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "email.empty");
        if (personDto.getAge() < 0) {
            errors.rejectValue("age", "age negate");
        }
        AddressDto addressDto = personDto.getAddress();
        if (addressDto != null) {
            try {
                errors.pushNestedPath("address");
                ValidationUtils.invokeValidator(addressDtoValidator, personDto.getAddress(), errors);
            } finally {
                errors.popNestedPath();
            }
        }
    }
}
