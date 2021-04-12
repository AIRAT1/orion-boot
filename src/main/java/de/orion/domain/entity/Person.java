package de.orion.domain.entity;

import de.orion.domain.enums.PersonType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "user")
@AttributeOverrides(
        @AttributeOverride(name = "id", column = @Column(name = "user_id"))
)
public class Person extends EntityBase{
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private Short age = -1;
    @Column(name = "email")
    private String email;

    @Column(name = "address_id")
    private UUID addressId;

    @Embedded
    @AttributeOverrides(
            @AttributeOverride(name = "street", column = @Column(name = "street1"))
    )
    private AddressEmbeddable addressEmbeddable;

    @Transient
    private Collection<PersonType> personTypeCollection;
}
