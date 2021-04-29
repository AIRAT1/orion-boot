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
@PrimaryKeyJoinColumn(name = "bank_account_id")
public class BankAccount extends BillingDetails{
    @Column(name = "account")
    private String account;

    @Override
    public BillingType getBilling() {
        return BillingType.ACCOUNT;
    }
}
