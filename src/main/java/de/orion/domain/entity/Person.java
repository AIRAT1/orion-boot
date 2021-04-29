package de.orion.domain.entity;

import de.orion.domain.entity.address.AddressMtm;
import de.orion.domain.entity.address.AddressMto;
import de.orion.domain.entity.address.AddressOto;
import de.orion.domain.enums.PersonType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "user")
@DynamicInsert
@DynamicUpdate
@AttributeOverrides(
        @AttributeOverride(name = "id", column = @Column(name = "user_id"))
)
public class Person extends EntityBase{
    @Column(name = "name")
    private String name;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "address_uuid")
    private AddressMto addressMto;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private AddressOto addressOto;

    @ManyToMany
    @JoinTable(
            name = "person_address_mtm",
            joinColumns = @JoinColumn(name = "address_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<AddressMtm> addressMtmSet;

    public void addAddressMtm(AddressMtm addressMtm) {
        getAddressMtmSet().add(addressMtm);
        addressMtm.getPeople().add(this);
    }
}
