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
public class ThirdParty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private byte[] hashedKey;

    public ThirdParty(String name, String message) throws NoSuchAlgorithmException{

        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] encodedHashKey = digest.digest(
                message.getBytes(StandardCharsets.UTF_8));
        this.hashedKey = encodedHashKey;
    }
}
