package com.ironhack.bankingsystem.users;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Address {
    @NotNull
    private String streetAddress;
    @NotNull
    private String city;
    @NotNull
    private String country;
    @NotNull
    private String postalCode;
}
