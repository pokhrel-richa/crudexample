package com.crudexample.crudexample.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "CLIENT")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "NAME")
    private String name;
    @Column(name ="USERNAME" )
    private String username;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "ACTIVE")
    private Character active;
    @Column(name = "RECORDED_DATE")
    @Temporal(TemporalType.DATE)
    private Date recorded_date = new Date(System.currentTimeMillis());

}
