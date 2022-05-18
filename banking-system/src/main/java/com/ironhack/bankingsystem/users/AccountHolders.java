package com.ironhack.bankingsystem.users;

import com.ironhack.bankingsystem.models.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "account_holders")
public class AccountHolders extends User{

    @NotNull
    private String dateOfBirth;
    @NotNull
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "streetAddress", column = @Column(name = "primary_Street_Address")),
            @AttributeOverride(name = "city", column = @Column(name = "primary_address_city")),
            @AttributeOverride(name = "country", column = @Column(name = "primary_address_country")),
            @AttributeOverride(name = "postalCode", column = @Column(name = "primary_address_postalCode"))
    })
    private Address primaryAddress;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "streetAddress", column = @Column(name = "mailing_address_Street")),
            @AttributeOverride(name = "city", column = @Column(name = "mailing_address_city")),
            @AttributeOverride(name = "country", column = @Column(name = "mailing_address_country")),
            @AttributeOverride(name = "postalCode", column = @Column(name = "mailing_address_postalCode"))
    })
    private Address mailingAddress;

  /*  @OneToMany*/

    public AccountHolders(String name, String password, String username, String dateOfBirth, Address primaryAddress, Address mailingAddress) {
        super(name, password, username);
        this.dateOfBirth = dateOfBirth;
        this.primaryAddress = primaryAddress;
        this.mailingAddress = mailingAddress;
    }

    public AccountHolders(Long id, @NotNull String name, @NotNull String password, @NotNull String username, Collection<Role> roles, String dateOfBirth, Address primaryAddress, Address mailingAddress) {
        super(id, name, password, username, roles);
        this.dateOfBirth = dateOfBirth;
        this.primaryAddress = primaryAddress;
        this.mailingAddress = mailingAddress;
    }

    public AccountHolders(String name, String username, Collection<Role> roles, String password, String dateOfBirth, Address primaryAddress, Address mailingAddress) {
        super(name, password, username, roles);
        this.dateOfBirth = dateOfBirth;
        this.primaryAddress = primaryAddress;
        this.mailingAddress = mailingAddress;
    }
}
