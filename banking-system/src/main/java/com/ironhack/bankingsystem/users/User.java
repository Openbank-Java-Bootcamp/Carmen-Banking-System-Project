package com.ironhack.bankingsystem.users;

import com.ironhack.bankingsystem.models.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Collection;

import static jakarta.persistence.FetchType.EAGER;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Please insert a name")
    private String name;
    @NotNull(message = "Please insert a password")
    private String password;
    @NotNull(message = "Please insert a username")
    private String username;
    @ManyToMany(fetch = EAGER)
    private Collection<Role> roles = new ArrayList<>();

    public User(String name, String password, String username) {
        this.name = name;
        this.password = password;
        this.username = username;

    }

    public User(String name, String password, String username, Collection<Role> roles) {
        this.name = name;
        this.password = password;
        this.username = username;
        this.setRoles(roles);
    }
}
