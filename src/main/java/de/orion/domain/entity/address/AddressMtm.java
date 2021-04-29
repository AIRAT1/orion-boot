package de.orion.domain.entity.address;

import de.orion.domain.entity.Person;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
@Getter
public class AddressMtm extends AddressBase{
    @ManyToMany(mappedBy = "addressMtmSet")
    private Set<Person> people;
}
