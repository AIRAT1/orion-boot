package de.orion.validator.custom;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
@Constraint(validatedBy = EmailValidator.class)
public @interface CustomEmail {
    String message() default "Email is not correct";
    Class<?> groups() [] default {};
    Class<? extends Payload> [] payload() default {};
}
