package de.orion.domain.entity.address;

import de.orion.domain.entity.EntityBase;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
public class AddressBase extends EntityBase {
    @Column(name = "street")
    private String street;
    @Column(name = "city")
    private String city;
}
