package de.orion.domain.entity.address;

import de.orion.domain.entity.Person;
import org.hibernate.annotations.BatchSize;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class AddressMto extends AddressBase{
    @BatchSize(size = 10)
    @OneToMany(mappedBy = "addressMto")
    private List<Person> people;
}
