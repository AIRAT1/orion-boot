package de.orion.dto;

import de.orion.validator.custom.CustomEmail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonDto {
    private String id;
    @NotEmpty
    @NotNull
    private String name;
    @Positive
    private Short age;
    @CustomEmail
    private String email;
    private AddressDto address;
}
