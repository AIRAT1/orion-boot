package de.orion.validator.mvc;

import de.orion.domain.dto.AddressDto;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class AddressDtoValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(AddressDto.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "street", "street.empty");
    }
}
