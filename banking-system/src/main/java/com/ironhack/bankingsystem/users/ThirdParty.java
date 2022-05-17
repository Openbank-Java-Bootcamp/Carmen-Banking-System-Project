package com.ironhack.bankingsystem.users;
import com.ironhack.bankingsystem.models.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "third_party")
public class ThirdParty extends User{

    @NotNull
    private byte[] hashedKey;

    public ThirdParty(String name, String password,  String username, Role role,  String message) throws NoSuchAlgorithmException{
        super(name, password, username);
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] encodedHashKey = digest.digest(
                message.getBytes(StandardCharsets.UTF_8));
        this.hashedKey = encodedHashKey;
    }
}
