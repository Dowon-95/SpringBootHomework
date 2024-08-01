package com.example.practice.dto;

import com.example.practice.entity.Users;
import lombok.Getter;

@Getter
public class UserDTO {
    private String name;
    private String email;
    private String number;

    public Users toEntity() {
        return new Users(name, email, number);
    }

}
