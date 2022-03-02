package com.crudexample.crudexample.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ClientResponse {
    private String name;
    private String username;
    private Character active;
}
