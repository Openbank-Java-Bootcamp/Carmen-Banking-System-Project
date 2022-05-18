package com.ironhack.bankingsystem.users;

import com.ironhack.bankingsystem.models.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@Table(name = "admin")
public class Admin extends User {

   /* @OneToOne(fetch = FetchType.EAGER)
    private Role role = new Role();*/

    public Admin(String name, String password, String username) {
        super(name, password, username);
    }


}
