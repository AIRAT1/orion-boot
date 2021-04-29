package de.orion.domain.dto;

import lombok.Data;

@Data
public class AddressDto {
    private String id;
    private String street;
    private String house;
    private String apartment;
}
