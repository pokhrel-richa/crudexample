package com.crudexample.crudexample.dto;
import lombok.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class UserCheck {
    private String name;
    private String username;
    private String password;
    private Character active;
}
