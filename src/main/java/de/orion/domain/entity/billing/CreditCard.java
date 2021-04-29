package de.orion.domain.entity.billing;

import de.orion.domain.enums.BillingType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@Getter
@Setter
@PrimaryKeyJoinColumn(name = "credit_card_id")
public class CreditCard extends BillingDetails{
    @Column
    private String cardNumber;

    @Override
    public BillingType getBilling() {
        return BillingType.CARD;
    }
}
