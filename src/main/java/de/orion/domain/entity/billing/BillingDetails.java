package de.orion.domain.entity.billing;

import de.orion.domain.entity.EntityBase;
import de.orion.domain.enums.BillingType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.util.UUID;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BillingDetails extends EntityBase {
    private UUID personId;

    public abstract BillingType getBilling();
}
