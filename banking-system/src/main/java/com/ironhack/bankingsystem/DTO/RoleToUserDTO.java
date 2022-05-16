package com.ironhack.bankingsystem.DTO;

import lombok.Data;

@Data
public class RoleToUserDTO {
    private String username;
    private String roleName;

    public RoleToUserDTO(String username, String roleName) {
        this.username = username;
        this.roleName = roleName;
    }
}
