package de.orion.domain.dto;

import de.orion.validator.custom.CustomEmail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto {
    private UUID id;
    @NotNull
    @NotEmpty
    private String name;
    private Short age = -1;
    @CustomEmail
    private String email;
    private UUID addressId;
    private AddressDto address;
}
