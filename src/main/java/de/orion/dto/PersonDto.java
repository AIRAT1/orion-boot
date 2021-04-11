package de.orion.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonDto {
    private String id;
    private String name;
    private Short age;
    private String email;
    private AddressDto address;
}
