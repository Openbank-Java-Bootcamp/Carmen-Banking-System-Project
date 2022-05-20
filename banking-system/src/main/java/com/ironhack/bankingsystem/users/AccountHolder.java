package com.ironhack.bankingsystem.users;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "account_holders")
public class AccountHolder extends User{
    /*@JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @NotNull
    private LocalDate dateOfBirth;*/
    @NotNull
    private Date dateOfBirth;
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


    public AccountHolder(String name, String password, String username, Date dateOfBirth, Address primaryAddress, Address mailingAddress) {
        super(name, password, username);
        this.dateOfBirth = dateOfBirth;
        this.primaryAddress = primaryAddress;
        this.mailingAddress = mailingAddress;
    }


}
