package de.orion.domain.entity.address;

import de.orion.domain.entity.Person;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class AddressOto extends AddressBase{
    @OneToOne(mappedBy = "addressOto")
    private Person person;
}
