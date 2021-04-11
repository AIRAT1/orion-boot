package de.orion.validator.custom;


import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<CustomEmail, String> {
    private CustomEmail customEmail;

    @Override
    public void initialize(CustomEmail constraintAnnotation) {
        customEmail = constraintAnnotation;
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return StringUtils.isNotEmpty(s) && s.contains("@");
    }
}
