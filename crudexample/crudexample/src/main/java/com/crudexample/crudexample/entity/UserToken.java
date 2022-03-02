package com.crudexample.crudexample.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "user_token")
public class UserToken {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long id;
    @Column(name ="token")
    private String token;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

}
